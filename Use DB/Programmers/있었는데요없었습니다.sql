SELECT ain.ANIMAL_ID, ain.NAME FROM ANIMAL_INS ain 
LEFT JOIN ANIMAL_OUTS aout 
ON ain.ANIMAL_ID = aout.ANIMAL_ID 
where ain.DATETIME > aout.DATETIME 
ORDER BY ain.DATETIME ASC ;
-- https://programmers.co.kr/learn/courses/30/lessons/59043