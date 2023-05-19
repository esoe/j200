CREATE DATABASE ACCESS;

CREATE TABLE Access.Accounts (
    id INT NOT NULL AUTO_INCREMENT,
	login VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO Access.Accounts (login, password)
VALUES
	('free', 'free'),
	('esoe', 'psalm6912');
	
SELECT * from Access.Accounts;