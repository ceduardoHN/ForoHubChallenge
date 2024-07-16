ALTER TABLE tbluser MODIFY COLUMN password VARCHAR(250) NOT NULL;

UPDATE tbluser SET password = '$2y$10$OTqmK7I85qyp.Z7feziadOrwEsYGp/BeF5soV.APocvF/mqKO7WRK';