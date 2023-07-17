--liquibase formatted sql
--changeset amroczkowski:3

alter table product add category_id bigint after category;
alter table product drop column category;
alter table product add constraint fk_product_category_id foreign key (category_id) references category(id);