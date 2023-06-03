--liquibase formatted sql

--changeset Saifutdiyarov_Askar:ddl-v1 dbms:postgresql context:general-ddl

CREATE TABLE example
(
    id   bigint PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);