CREATE TABLE j200.Addresses(
	id INT NOT NULL AUTO_INCREMENT,
	ip VARCHAR(15),
	mac VARCHAR(17),
	model VARCHAR(100),
	address VARCHAR(100),
	client_id INT NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY (client_id) REFERENCES j200.Clients (id)
);

CREATE TABLE Access.Accounts (
    id INT NOT NULL AUTO_INCREMENT,
	login VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

