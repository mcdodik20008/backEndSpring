--liquibase formatted sql

--changeset author:kaspshitskii
--comment optional тест работы миграций
CREATE TABLE backend.file_document
(
    id        int8,
    name      varchar(50),
    file_Path varchar(255),
    file_Type varchar(255),
    CONSTRAINT id PRIMARY KEY (id)
);
