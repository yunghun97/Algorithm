DELETE a
FROM person a JOIN person b
WHERE a.id > b.id AND a.email = b.email;