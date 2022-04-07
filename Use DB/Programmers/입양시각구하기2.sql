SET @HOUR = -1; # 변수 선언
SELECT (@HOUR := @HOUR +1) AS HOUR, # 사용자 정의 변수 사용 SET @변수이름 = 대입값 , SET @변수이름 := 대입값, SELECT @변수이름 := 대입값 -> SELECT 에서는 = 는 안된다. SET에서만 가능
(SELECT COUNT(*) FROM ANIMAL_OUTS WHERE HOUR(DATETIME) = @HOUR) AS COUNT  # Sub Query 결과 값은 1개여야 합니다.
FROM ANIMAL_OUTS
WHERE @HOUR < 23