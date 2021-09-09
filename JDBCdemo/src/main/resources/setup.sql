-- This is the script 
DROP TYPE IF EXISTS sebasvn.user_role CASCADE;
CREATE TYPE sebasvn.user_role AS ENUM ('Admin', 'Employee', 'Customer');

-- This is just a demo of JDBC connection
DROP TABLE IF EXISTS sebasvn.users CASCADE;
CREATE TABLE sebasvn.users (
	id SERIAL PRIMARY KEY,
	username VARCHAR(50) NOT NULL UNIQUE,
	pwd VARCHAR(50) NOT NULL, 
	user_role sebasvn.user_role NOT NULL
);

DROP TABLE IF EXISTS sebasvn.accounts CASCADE;
CREATE TABLE sebasvn.accounts (
	id SERIAL PRIMARY KEY,
	balance NUMERIC (50, 2) DEFAULT 0,
	acc_owner INTEGER NOT NULL REFERENCES sebasvn.users(id),
	active BOOLEAN DEFAULT FALSE -- This IS determining whether the account has been activated
	
);

DROP TABLE IF EXISTS sebasvn.users_accounts_jt CASCADE;
-- This is demonstratinga MANY to MANY relationship ...
CREATE TABLE sebasvn.users_accounts_jt (
	acc_owner INTEGER NOT NULL REFERENCES sebasvn.users(id),
	account INTEGER NOT NULL REFERENCES sebasvn.accounts(id)
);

DROP TABLE IF EXISTS sebasvn.applications CASCADE;
CREATE TABLE sebasvn.applications (
	id SERIAL PRIMARY KEY,
	app_owner INTEGER NOT NULL REFERENCES sebasvn.users(id)
);

-- Create the function to insert elements of a new Account record into the 
-- THE users_account_jt
CREATE OR REPLACE FUNCTION sebasvn.auto_insert_into_jt() RETURNS TRIGGER AS
$BODY$
BEGIN
	
	INSERT INTO
		sebasvn.users_accounts_jt(acc_owner, account)
		VALUES(NEW.acc_owner, NEW.id);
			RETURN NEW;
	
END
$BODY$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION sebasvn.multiply(x NUMERIC, y NUMERIC)
RETURNS NUMERIC
AS $$

	BEGIN 	
		RETURN $1 * $2;
	END
	
	$$
LANGUAGE plpgsql;


CREATE TRIGGER trig
	AFTER INSERT ON sebasvn.accounts
	FOR EACH ROW
	EXECUTE PROCEDURE sebasvn.auto_insert_into_jt();


-- JOIN from the accounrs table and the users_account_jt WHERE the accowner_id is the same as the userId
SELECT sebasvn.accounts.id, sebasvn.accounts.balance FROM sebasvn.accounts
INNER JOIN sebasvn.users_accounts_jt 
ON sebasvn.accounts.id = sebasvn.users_accounts_jt.account 
WHERE sebasvn.users_accounts_jt.acc_owner = 6



-- create a function with variables
-- that fetches the very last track from the chinook db

SELECT * FROM chinook."Track";

CREATE OR REPLACE FUNCTION chinook.get_last_track_info()
RETURNS TEXT 
AS $$

	DECLARE -- DECLARE variables TO use IN the FUNCTION body 
	largest INT;
	track_name TEXT;
	end_result TEXT;

BEGIN

	-- AGGREGATE FUNCTION
	SELECT max("TrackId")
	INTO largest
	FROM chinook."Track";
	
	-- Save the name as the Track name
	-- Select the "Name" columm from the track table where the TrackID is the largest
	SELECT "Name" 
	INTO track_name
	FROM chinook."Track" WHERE "TrackId" = largest;
	
	end_result := largest || ' ' || track_name;
	
	RETURN end_result;
END


$$
LANGUAGE plpgsql; 

SELECT * FROM chinook.get_last_track_info();

	

SELECT * FROM sebasvn.users;
SELECT * FROM sebasvn.accounts;
SELECT * FROM sebasvn.users_accounts_jt;

















