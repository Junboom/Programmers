   SELECT      o.ANIMAL_ID, o.NAME
     FROM      ANIMAL_OUTS o
LEFT JOIN      ANIMAL_INS i
       ON      o.ANIMAL_ID = i.ANIMAL_ID
    WHERE      i.ANIMAL_ID is NULL;
