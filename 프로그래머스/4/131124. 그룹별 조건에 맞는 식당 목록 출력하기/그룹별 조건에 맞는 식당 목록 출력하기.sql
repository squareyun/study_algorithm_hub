-- 코드를 입력하세요
SELECT M.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM MEMBER_PROFILE M JOIN REST_REVIEW R ON M.MEMBER_ID = R.MEMBER_ID
WHERE M.MEMBER_ID IN (
    SELECT MEMBER_ID
    FROM REST_REVIEW
    GROUP BY MEMBER_ID
    HAVING COUNT(*) = (
        SELECT MAX(TOTAL) FROM
            (SELECT COUNT(*) AS TOTAL
            FROM REST_REVIEW
            GROUP BY MEMBER_ID
            ) AS MAX_REVIEWS
        )
    )
ORDER BY R.REVIEW_DATE ASC, R.REVIEW_TEXT ASC;