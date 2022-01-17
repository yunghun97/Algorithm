SELECT HOUR(DATETIME) as HOUR, COUNT(*) as count from ANIMAL_OUTS group by HOUR having HOUR between 9 and 19 order by HOUR asc;
-- having 절에는 순수한 컬럼명(가공 되지않은)이 들어가야 한다.
-- https://programmers.co.kr/learn/courses/30/lessons/59412