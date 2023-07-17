--liquibase formatted sql
--changeset amroczkowski:2

create table category(
                         id bigint not null auto_increment PRIMARY KEY,
                         name varchar(255) not null,
                         description text,
                         url varchar(255) not null
);