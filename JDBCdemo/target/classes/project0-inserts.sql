INSERT INTO users (username, first_name, last_name, pwd, user_role) 
	VALUES ('ironman', 'tony', 'stark', '1234', 'CUSTOMER');

SELECT u.id AS id_user, username, first_name, last_name, pwd, user_role, a.id AS id_account, balance, active
FROM project0.users u
JOIN project0.accounts a ON a.id_owner = u.id 
WHERE username = 'sebasvn' AND pwd = '1234'

INSERT INTO accounts (balance, id_owner)
VALUES (30000, 1)

DELETE FROM users
DELETE FROM accounts


SELECT * FROM accounts WHERE ACTIVE = FALSE 