--liquibase formatted sql
--changeset amroczkowski:4

insert into category (id, name, description, url) values(1, 'test', '', 'test');
update product set category_id=1;
alter table product MODIFY category_id bigint not null;