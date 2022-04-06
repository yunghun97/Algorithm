SELECT ain.ANIMAL_ID as ANIMAL_ID, ain.ANIMAL_TYPE as ANIMAL_TYPE, ain.NAME as NAME
from ANIMAL_INS ain
JOIN ANIMAL_OUTS aout
ON ain.ANIMAL_ID = aout.ANIMAL_ID 
and ain.SEX_UPON_INTAKE like '%Intact%' 
and(aout.SEX_UPON_OUTCOME like 'Spayed%' OR aout.SEX_UPON_OUTCOME like 'Neutered%');