SELECT ain.ANIMAL_ID, ain.NAME
FROM ANIMAL_INS ain
LEFT JOIN ANIMAL_OUTS aout
ON ain.ANIMAL_ID = aout.ANIMAL_ID
ORDER BY aout.DATETIME-ain.DATETIME DESC 
LIMIT 2;
-- https://programmers.co.kr/learn/courses/30/lessons/59411