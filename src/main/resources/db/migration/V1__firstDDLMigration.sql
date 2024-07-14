CREATE TABLE tbltopic(
    idtopic BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(500) NOT NULL,
    message VARCHAR(5000) NOT NULL,
    generationdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status ENUM('ESTADO1','ESTADO2','ESTADO3') NOT NULL,
    iduser BIGINT NOT NULL,
    idcourse BIGINT NOT NULL
);
CREATE TABLE tblcourse(
    idcourse BIGINT PRIMARY KEY AUTO_INCREMENT,
    coursename VARCHAR(50) NOT NULL,
    category ENUM('CAT1','CAT2','CAT3') NOT NULL
);
CREATE TABLE tbluser(
    iduser BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(30) NOT NULL
);

-- ALTERS
ALTER TABLE tbltopic
    ADD CONSTRAINT fk_topics_users FOREIGN KEY (iduser) REFERENCES tbluser(iduser),
    ADD CONSTRAINT fk_topics_courses FOREIGN KEY (idcourse) REFERENCES tblcourse(idcourse)
;