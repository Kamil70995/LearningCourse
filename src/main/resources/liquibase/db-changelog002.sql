--liquibase formatted sql

--changeset Saifutdiyarov_Askar:ddl-v2 dbms:postgresql context:general-ddl

CREATE SEQUENCE author_pk_seq INCREMENT BY 50;
CREATE TABLE author
(
    id               bigint PRIMARY KEY default nextval('author_pk_seq'),
    author_name      VARCHAR(40)  NOT NULL,
    author_lastname  VARCHAR(40)  NOT NULL,
    author_email     VARCHAR(40)  NOT NULL,
    author_password  VARCHAR(255) NOT NULL,
    author_birthdate DATE         NOT NULL
);

CREATE INDEX author_name_lastname_index ON author (author_name, author_lastname);
CREATE UNIQUE INDEX author_email_index ON author (author_email);


CREATE SEQUENCE user_client_pk_seq INCREMENT BY 50;
CREATE TABLE user_client
(
    id               bigint PRIMARY KEY DEFAULT nextval('user_client_pk_seq'),
    client_name      VARCHAR(40)  NOT NULL,
    client_lastname  VARCHAR(40)  NOT NULL,
    client_email     VARCHAR(40)  NOT NULL,
    client_password  VARCHAR(255) NOT NULL,
    client_birthdate DATE         NOT NULL
);

CREATE INDEX user_name_lastname_index ON user_client (client_name, client_lastname);
CREATE UNIQUE INDEX user_email_index ON user_client (client_email);

CREATE SEQUENCE course_pk_seq INCREMENT BY 50;
CREATE TABLE course
(
    id            bigint PRIMARY KEY,
    course_title  VARCHAR(40) NOT NULL,
    course_author bigint      NOT NULL REFERENCES author (id),
    upload_date   DATE        NOT NULL,
    content       oid
);

CREATE TABLE user_course
(
    user_id   bigint NOT NULL,
    course_id bigint NOT NULL,
    PRIMARY KEY (user_id, course_id),
    CONSTRAINT user_course_fk_1 FOREIGN KEY (user_id) REFERENCES user_client (id),
    CONSTRAINT user_course_fk_2 FOREIGN KEY (course_id) REFERENCES course (id)
);

CREATE SEQUENCE test_pk_seq INCREMENT BY 50;
CREATE TABLE test
(
    id          bigint PRIMARY KEY DEFAULT nextval('test_pk_seq'),
    content     oid,
    test_course bigint NOT NULL REFERENCES course (id)
);

