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
  
### 조건문
```sql
-- IF(조건, true일 떄, false 일 때)
SELECT ANIMAL_ID, NAME, 
IF (SEX_UPON_INTAKE LIKE '%Neutered%' OR SEX_UPON_INTAKE LIKE '%Spayed%', 'O', 'X') AS '중성화' 
from ANIMAL_INS 

-- CASE WHEN(조건) Then true일 때, WHEN(조건) Then true일 때 ELSE false일 때 END
CASE 
WHEN (SEX_UPON_INTAKE LIKE '%Neutered%' OR SEX_UPON_INTAKE LIKE '%Spayed%') Then 'O'
ELSE 'X'
END
```

## DB 날짜 양식 변환
```sql
-- DATETIME 포맷 변경
date_format(날짜포맷컬럼, '%Y-%m-%d') as 이름
 
-- 결과 :  2022-02-10 
```
![날짜변환표](https://user-images.githubusercontent.com/71022555/153426741-12f88046-75a9-44c9-850a-32fdfefb0a1d.png)

## IN EXISTS 차이
- ### IN
    - IN 뒤에 있는 괄호의 서브쿼리르 먼저 실행해서 그에 대한 요소를 가져온다. 그 후 IN 단계의 SQL 문법을 실행하여 IN 이하의 요소들에 포함되어 있는지 체크한다.
- ### EXISTS
    - 먼저 EXISTS 단계의 SQL을 실행하여 정보를 가져온다. 그 후 그 정보를 활용하여 EXISTS 이하의 서브쿼리를 실행하고 서브쿼리에 대한 결과가 존재하는지를 검사하여 존재 시 결과값을 가진다.