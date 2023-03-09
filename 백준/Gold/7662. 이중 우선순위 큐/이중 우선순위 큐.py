# TITLE: 제곱 ㄴㄴ 수 (https://www.acmicpc.net/problem/1016)
# LEVEL: Gold 1
# TAG: math, number_tehory, primality_test, sieve
# DATE: 20220820
# AUTHOR: squareyun
# REFERENCE: https://bit.ly/3T1zPc3

import heapq
import sys
INF=1e9
input=sys.stdin.readline

t=int(input())
for _ in range(t):
    minheap = []
    maxheap = []
    popHistory = dict()
    k = int(input())
    for _ in range(k):


        op, n = input().split()
        if op == 'I':
            n = int(n)
            heapq.heappush(minheap, n)
            heapq.heappush(maxheap, -n)
            if n in popHistory:
                    popHistory[n] += 1
            else:
                popHistory[n] = 1

        elif op == 'D':
            if n == '1':
                while len(maxheap) != 0:
                    popElement = -heapq.heappop(maxheap)
                    if popHistory[popElement] != 0:
                        popHistory[popElement] -= 1
                        break

            elif n == '-1':
                while len(minheap) != 0:
                    popElement = heapq.heappop(minheap)
                    if popHistory[popElement] != 0:
                        popHistory[popElement] -= 1
                        break
    #동기화
    answerMax, answerMin = -INF, INF
    while len(maxheap) != 0:
        if popHistory[-maxheap[0]] != 0 :
            answerMax = -maxheap[0]
            break
        else:
            heapq.heappop(maxheap)

    while len(minheap) != 0:
        if popHistory[minheap[0]] != 0 :
            answerMin = minheap[0]
            break
        else:
            heapq.heappop(minheap)
    
    if answerMax == -INF or answerMin == INF:
        print('EMPTY')
    else:
        print(f'{answerMax} {answerMin}')