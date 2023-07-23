--liquibase formatted sql
--changeset amroczkowski:17

insert into users (id, username, password, enabled)
values (2, 'admin1', '{bcrypt}$2a$12$ytRKNWwYcdedekqteFHtEeHLzPVtUkaVPzIuDjPEXe7em3UqxMyyq', true);
insert into authorities (username, authority) values ('admin1','ROLE_ADMIN');