SELECT a.ANIMAL_TYPE, IFNULL(a.NAME,"No name"), a.SEX_UPON_INTAKE from ANIMAL_INS a order by ANIMAL_ID;
-- IFNULL(컬럼명,"NULL일 떄 들어갈 값")
-- https://programmers.co.kr/learn/courses/30/lessons/59410