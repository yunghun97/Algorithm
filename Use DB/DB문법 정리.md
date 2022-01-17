## MYSQL 기준

### - SQL 구분 동작 순서
### ex) Select 컬럼 From 테이블 Where 조건 GROUP BY 컬럼명 HAVING 그룹 조건 ORDER BY 컬럼명
### 결과
1. FROM 
2. WHERE
3. GROUP BY
4. HAVING
5. SELECT
6. ORDER BY
###  SELECT 다음으로 오는 구문은 ORDER BY 뿐이므로, SELECT 에서 만들어진 Alias 는 ORDER BY 구문에서만 사용 가능합니다. 
🧨 *** MySQL에서는 SELECT 문에 사용된 컬럼을 사용하는 것도 허용된다. ***

### IFNULL
- ### IFNULL(컬럼명,"NULL일 떄 들어갈 값")
    - NULL 값이면 해당 문제를 출력
### HAVING
- SQL에서는 기본적으로 GROUP BY 절에 있거나 집계 함수가 사용된 컬럼만을 HAVING 절에서 사용할 수 있다. MYSQL은 Select 절 컬럼 가능
- having 절에는 순수한 컬럼명(가공 되지않은(집계 함수는 가능))이 들어가야 한다.
