SELECT DISTINCT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS A
JOIN SKILLCODES B
ON (A.SKILL_CODE & B.CODE) <> 0
WHERE B.CATEGORY = 'Front End'
ORDER BY A.ID