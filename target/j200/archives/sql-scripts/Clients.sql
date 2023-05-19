CREATE TABLE IF NOT EXISTS j200.Clients(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100),
	client_type VARCHAR(100),
	added VARCHAR(100),
	PRIMARY KEY(id)
	-- CHECK (client_type in ('Физическое лицо', 'Юридическое лицо'))
);

DROP TABLE j200.Addresses;

DROP TABLE j200.Clients;

INSERT INTO j200.Clients
    (name,
    client_type,
    added)
VALUES
   ('Сергей Иванов', 'Физическое лицо', '2020-11-22'),
   ('Ирина Викторова', 'Физическое лицо', '2020-11-28'),
   ('Павел Николаев', 'Физическое лицо', '2020-12-03'),
   ('Антонина Васильева', 'Физическое лицо', '2020-12-03'),
   ('Авалон', 'Юридическое лицо', '2022-08-03');
