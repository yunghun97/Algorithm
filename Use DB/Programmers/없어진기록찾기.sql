SELECT anout.ANIMAL_ID, anout.NAME as ANIMAL_ID 
FROM ANIMAL_OUTS anout 
LEFT OUTER JOIN ANIMAL_INS anin 
ON anin.ANIMAL_ID = anout.ANIMAL_ID
WHERE anin.ANIMAL_ID is null
ORDER BY anout.ANIMAL_ID ASC;
-- https://programmers.co.kr/learn/courses/30/lessons/59042?language=mysql