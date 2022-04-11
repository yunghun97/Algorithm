SELECT cp1.CART_ID 
FROM ( select * from CART_PRODUCTS cp2 where cp2.NAME="Yogurt" GROUP BY cp2.CART_ID
) as cp1
JOIN ( select * from CART_PRODUCTS cp2 where cp2.NAME="Milk" GROUP BY cp2.CART_ID
) as cp2
ON cp1.CART_ID = cp2.CART_ID;
-- https://programmers.co.kr/learn/courses/30/lessons/62284