SELECT ain.NAME, ain.DATETIME
FROM ANIMAL_INS ain
LEFT JOIN ANIMAL_OUTS aout
ON ain.ANIMAL_ID = aout.ANIMAL_ID
where aout.ANIMAL_ID is NULL
ORDER BY ain.DATETIME ASC
limit 3;

-- https://programmers.co.kr/learn/courses/30/lessons/59044