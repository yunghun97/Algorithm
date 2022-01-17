SELECT a.NAME, count(*) as COUNT from ANIMAL_INS a group by(a.NAME) having count(a.NAME)>=2 order by a.NAME;
-- https://programmers.co.kr/learn/courses/30/lessons/59041