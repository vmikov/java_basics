set search_path to javaelementary;
select * from clients;
alter table clients add column age int;

DO $$
DECLARE 
	cl_id INTEGER;
	crs_clients CURSOR FOR SELECT id FROM clients;
BEGIN
	OPEN crs_clients;
	FETCH FROM crs_clients INTO cl_id;
	WHILE cl_id IS NOT NULL LOOP 
		UPDATE clients SET age = 18 + CEILING(RANDOM() * 72) WHERE id = cl_id;
		FETCH FROM crs_clients INTO cl_id;
	END LOOP;
	COMMIT;
	CLOSE crs_clients;
END $$;

update clients set age = 16 where id = 1;
update clients set age = 17 where id = 2;
update clients set age = 18 where id = 3;
commit;

alter table clients alter column age not null;
