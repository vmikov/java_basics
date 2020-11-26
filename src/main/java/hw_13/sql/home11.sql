--1

--1.1
CREATE TABLE clients (
	id serial CONSTRAINT pk_clients PRIMARY KEY,
	name VARCHAR(20),
	email VARCHAR(255) NOT NULL CONSTRAINT unq_email UNIQUE,
	phone BIGINT NOT NULL CONSTRAINT unq_phone UNIQUE,
	about TEXT 
);

--1.2
CREATE TABLE statuses (
	id serial CONSTRAINT pk_statuses PRIMARY KEY,
	alias VARCHAR(15) NOT NULL CONSTRAINT unq_alias UNIQUE,
	description TEXT NOT NULL
);

--1.3
CREATE TABLE client_status (
	client_id INT NOT NULL,
	status_id INT NOT NULL
);

--1.4
CREATE TABLE accounts (
	id serial CONSTRAINT pk_accounts PRIMARY KEY,
	client_id INT NOT NULL,
	number VARCHAR(20) NOT NULL CONSTRAINT unq_number UNIQUE,
	value NUMERIC NOT NULL
);


--2

--2.1
INSERT INTO clients (name, email, phone, about) 
VALUES 	('Vasya', 'vasya@vas.net', 380958089090, 'senior programmer'),
	('Petya', 'petya@vas.net', 951234568, 'middle programmer'),
	('Kolya', 'kolya@vas.net', 951234569, 'junior programmer'),
	('Masha', 'masha@vas.net', 951234570, 'UX/UI designer'),
	('Sveta', 'sveta@vas.net', 951234571, 'frontender'),
	('Ivan', 'vanya@vas.net', 951234572, 'database developer'),
	('Alex', 'alex@vas.net', 951234573, 'project manager'),
	('Kapitoshka', 'kapitoshka@vas.net', 951234574, 'system administrator'),
	('Max', 'max@vas.net', 951234575, 'junior programmer'),
	('Dan', 'dan@vas.net', 951234576, 'junior programmer');

--2.2
INSERT INTO statuses (alias, description) 
VALUES 	('STANDARD', 'standard client''s activity'),
	('PREMIUM', 'priveleged client''s activity'),
	('VIP', 'VIP client''s activity');

--2.3
INSERT INTO client_status 
VALUES 	(1, 2),
	(2, 2),
	(3, 1),
	(4, 1),
	(5, 1),
	(6, 1),
	(7, 2),
	(8, 1),
	(9, 1),
	(10, 1);

--2.4	   
INSERT INTO accounts (client_id, number, value) 
VALUES 	(1, '11111111111111111111', 10000.63),
	(2, '22222222222222222222', 20000.99),
	(3, '33333333333333333333', 1.03),
	(4, '44444444444444444444', 0),
	(5, '55555555555555555555', 5500.25),
	(6, '66666666666666666666', 111.11),
	(7, '77777777777777777777', 22.22),
	(8, '88888888888888888888', 180000.76),
	(9, '99999999999999999999', 178.12),
	(10, '10000000000000000000', 19087.24);

--3

--3.1
SELECT * FROM clients WHERE phone = 380958089090;

--3.2
SELECT alias, description FROM statuses;

--3.3
SELECT number FROM accounts WHERE value > 1000.0;

--3.4
SELECT * FROM clients WHERE LENGTH(name) > 7; 

--3.5
SELECT * 
FROM clients
WHERE 	name IS NOT NULL AND 
	phone > 380951111111 AND 
	about IS NOT NULL;

--3.6	  
SELECT * FROM clients WHERE email LIKE 'alex%';

--3.7
SELECT * FROM clients ORDER BY phone DESC;

--3.8
SELECT *
FROM clients INNER JOIN accounts ON clients.id = accounts.client_id; 

--3.9
SELECT clients.name, clients.email, clients.phone, statuses.alias
FROM clients INNER JOIN client_status ON clients.id = client_status.client_id
	     INNER JOIN statuses ON client_status.status_id = statuses.id;