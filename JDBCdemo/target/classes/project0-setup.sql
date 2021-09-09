-- This is the script 
DROP TYPE IF EXISTS project0.user_role CASCADE;
CREATE TYPE project0.user_role AS ENUM ('ADMIN', 'EMPLOYEE', 'CUSTOMER');

-- This is just a demo of JDBC connection
DROP TABLE IF EXISTS project0.users CASCADE;
CREATE TABLE project0.users (
	id SERIAL PRIMARY KEY,
	username VARCHAR(50) NOT NULL UNIQUE,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(20) NOT NULL,
	pwd VARCHAR(50) NOT NULL, 
	user_role project0.user_role NOT NULL
);

DROP TABLE IF EXISTS project0.accounts CASCADE;
CREATE TABLE project0.accounts (
	id SERIAL PRIMARY KEY,
	balance NUMERIC (50, 2) DEFAULT 0,
	id_owner INTEGER NOT NULL REFERENCES project0.users(id),
	active BOOLEAN DEFAULT FALSE -- This IS determining whether the account has been activated
	
);

DROP TABLE IF EXISTS project0.users_accounts_jt CASCADE;
-- This is demonstratinga MANY to MANY relationship ...
CREATE TABLE project0.users_accounts_jt (
	acc_owner INTEGER NOT NULL REFERENCES project0.users(id),
	account INTEGER NOT NULL REFERENCES project0.accounts(id)
);

DROP TABLE IF EXISTS project0.applications CASCADE;
CREATE TABLE project0.applications (
	id SERIAL PRIMARY KEY,
	app_owner INTEGER NOT NULL REFERENCES project0.users(id)
);

