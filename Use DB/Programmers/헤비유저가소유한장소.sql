SELECT *
FROM PLACES p1
WHERE EXISTS(
    SELECT 1
    FROM PLACES p2
    WHERE p1.HOST_ID = p2.HOST_ID
    GROUP BY(HOST_ID)
    HAVING count(*) >=2
) 
ORDER BY ID ASC;

SELECT * 
FROM PLACES p1
WHERE p1.HOST_ID IN (
    SELECT HOST_ID
    FROM PLACES p2
    GROUP BY(p2.HOST_ID)
    HAVING count(*) >=2
)
ORDER BY ID ASC;

-- https://programmers.co.kr/learn/courses/30/lessons/77487