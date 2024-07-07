SELECT A.PRODUCT_ID, A.PRODUCT_NAME, (A.PRICE * B.AMOUNT) AS TOTAL_SALES
FROM FOOD_PRODUCT A
    JOIN (SELECT PRODUCT_ID, SUM(AMOUNT) AS AMOUNT
          FROM FOOD_ORDER
          WHERE YEAR(PRODUCE_DATE) = 2022
                AND MONTH(PRODUCE_DATE) = 5
          GROUP BY PRODUCT_ID) B
    ON A.PRODUCT_ID = B.PRODUCT_ID
GROUP BY PRODUCT_NAME
ORDER BY TOTAL_SALES DESC, A.PRODUCT_ID