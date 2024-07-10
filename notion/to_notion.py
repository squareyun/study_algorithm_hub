import os
import requests
import json
from bs4 import BeautifulSoup
import markdown2

# Constants
NOTION_API_KEY=os.environ['NOTION_API_KEY']
NOTION_DATABASE_ID=os.environ['NOTION_DATABASE_ID']

# Helper functions

# 로마 숫자를 아라비아 숫자로 변환
def roman_to_number(roman):
    rdict = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
    nv = roman[0]
    number = rdict[nv]
    for i in range(1, len(roman)):
        bv = nv
        nv = roman[i]
        if rdict[bv] >= rdict[nv]:
            number += rdict[nv]
        else:
            number += rdict[nv] - 2 * rdict[bv]
    return number

# Solved.ac 사이트의 문제 난이도 아이콘 URL 반환
def get_icon_url(teir, grade):
    TIER_DICT = {'Bronze': 0, 'Silver': 1, 'Gold': 2,
                 'Platinum': 3, 'Diamond': 4, 'Ruby': 5}
    teir_score = TIER_DICT[teir] * 5 - roman_to_number(grade) + 6
    return f'https://static.solved.ac/tier_small/{teir_score}.svg'


# Markdown 파일과 답안 파일에서 필요한 정보를 추출하여 Notion 페이지 생성에 필요한 JSON 형식으로 반환
def parse_problem_details(markdown_file, answer_file):
    with open(markdown_file, 'r', encoding='utf8') as f:
        markdown_text = f.read()
        html = markdown2.markdown(markdown_text)

    with open(answer_file, 'r', encoding='utf8') as f:
        answer = f.read()

    soup = BeautifulSoup(html, 'html.parser')
    teir, title = soup.find('h1').get_text().replace('[', '').split(']')
    teir, grade = teir.split()
    link = soup.find('a').attrs['href']
    icon = get_icon_url(teir, grade)

    p = soup.find_all('p', limit=3)
    memory, time = map(lambda x: x.split(': ')[
                       1], p[1].get_text().replace('[', '').split(', '))
    category = [{"name": c} for c in p[2].get_text().split(', ')]

    LANGUAGE_DICT = {'py': 'python', 'java': 'java'}
    language = LANGUAGE_DICT[os.path.splitext(answer_file)[1][1:]]

    return {
        'title': title,
        'link': link,
        'icon': icon,
        'teir': teir,
        'grade': grade,
        'category': category,
        'memory': memory,
        'time': time,
        'language': language,
        'answer': answer
    }


def create_database_page(data):
    with open('notion/template.json', 'r', encoding='UTF-8') as json_file:
        json_data = json.load(json_file)

    json_data['parent']['database_id'] = NOTION_DATABASE_ID

    # Set the page properties
    json_data['properties']['Title']['title'] = [
        {'text': {'content': data['title']}}]
    json_data['properties']['URL']['url'] = data['link']
    json_data['properties']['Tier']['select']['name'] = data['teir']
    json_data['properties']['Grade']['select']['name'] = data['grade']
    json_data['properties']['Category']['multi_select'] = data['category']
    json_data['icon']['external']['url'] = data['icon']

    # Set the code block
    for i in range(0, len(data['answer']), 2000):
        json_data['children'][3]['code']['rich_text'].append({
            'type': 'text',
            'text': {'content': data['answer'][i:i+2000]}
        })
    json_data['children'][3]['code']['language'] = data['language']

    # Set the memory and time table
    json_data['children'][1]["table"]['children'][1]['table_row']['cells'][0][0]['text']['content'] = data['memory']
    json_data['children'][1]["table"]['children'][1]['table_row']['cells'][1][0]['text']['content'] = data['time']
    return json_data


def read_problems_file():
    with open("notion/problems.json", 'r', encoding="UTF-8") as problems_file:
        problems = json.load(problems_file)
        sloved = problems['problems']
    return sloved, problems


def write_problems_file(problems):
    with open("notion/problems.json", 'w', encoding="UTF-8") as f:
        f.write(json.dumps(problems, ensure_ascii=False))

def find_existing_page(title, headers):
    query = {
        "filter": {
            "property": "Title",
            "title": {
                "equals": title
            }
        }
    }
    url = f"https://api.notion.com/v1/databases/{NOTION_DATABASE_ID}/query"
    response = requests.post(url, headers=headers, json=query)
    if response.status_code == 200:
        results = response.json()['results']
        if results:
            return results[0]['id']
    return None

def update_existing_page(page_id, data, headers):
    # Retrieve existing children blocks
    retrieve_url = f"https://api.notion.com/v1/blocks/{page_id}/children"
    response = requests.get(retrieve_url, headers=headers)
    
    if response.status_code == 200:
        existing_blocks = response.json()['results']
    else:
        print(f"Error retrieving page children: {response.text}")
        return

    update_blocks = []

    # Append new heading for performance summary
    update_blocks.append({
        "object": "block",
        "type": "heading_3",
        "heading_3": {
            "rich_text": [{
                "type": "text",
                "text": {"content": "성능 요약(복습ver)"}
            }]
        }
    })

    # Append new performance table
    update_blocks.append({
        "object": "block",
        "type": "table",
        "table": {
            "table_width": 2,
            "has_column_header": True,
            "has_row_header": False,
            "children": [
                {
                    "type": "table_row",
                    "table_row": {
                        "cells": [
                            [{"type": "text", "text": {"content": "Memory"}}],
                            [{"type": "text", "text": {"content": "Time"}}]
                        ]
                    }
                },
                {
                    "type": "table_row",
                    "table_row": {
                        "cells": [
                            [{"type": "text", "text": {"content": data['memory']}}], 
                            [{"type": "text", "text": {"content": data['time']}}]
                        ]
                    }
                }
            ]
        }
    })

    # Append new heading for the solution
    update_blocks.append({
        "object": "block",
        "type": "heading_3",
        "heading_3": {
            "rich_text": [{
                "type": "text",
                "text": {"content": "답안(복습ver)"}
            }]
        }
    })

    # Append new code block for the solution
    for i in range(0, len(data['answer']), 2000):
        update_blocks.append({
            "object": "block",
            "type": "code",
            "code": {
                "rich_text": [{"type": "text", "text": {"content": data['answer'][i:i+2000]}}],
                "language": data['language']
            }
        })

    # Use PATCH to append children
    response = requests.patch(f"https://api.notion.com/v1/blocks/{page_id}/children", headers=headers, json={"children": update_blocks})
    print(f"Updated Notion page {page_id} with status code {response.status_code}")

    if response.status_code != 200:
        print(f"Error updating page: {response.text}")


def create_pages():
    headers = {
        "Authorization": "Bearer " + NOTION_API_KEY,
        "Content-Type": "application/json",
        "Notion-Version": "2022-06-28"
    }

    solved, problems = read_problems_file()

    for (root, directories, files) in os.walk("백준"):
        for d in directories:
            d_path = os.path.join(root, d)
            readme, answer = "", ""
            for i in os.listdir(d_path):
                if i.endswith('.md'):
                    readme = os.path.join(d_path, i)
                elif i.endswith('.py') or i.endswith('.java'):
                    answer = os.path.join(d_path, i)

            if not readme or not answer:
                continue

            # Parse problem details
            data = parse_problem_details(readme, answer)

            # Find existing page and update, or create new page
            page_id = find_existing_page(data['title'], headers)

            if page_id:
                update_existing_page(page_id, data, headers)
            else:
                # Create Notion page
                json_data = json.dumps(create_database_page(data))
                
                # Add page to the database
                url = "https://api.notion.com/v1/pages"
                response = requests.post(url, headers=headers, data=json_data)

                if response.status_code == 200:
                    print(f"Page for {d_path} created successfully.")
                    solved.append(d_path)
                    problems['problems'] = solved
                    write_problems_file(problems)
                else:
                    print(f"Error creating page for {d_path}: {response.text}")

create_pages()