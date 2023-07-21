--liquibase formatted sql
--changeset amroczkowski:7

create table `order`(
                        id bigint not null auto_increment PRIMARY KEY,
                        placeDate datetime not null,
                        orderStatus varchar(32) not null,
                        grossValue decimal(6,2) not null,
                        firstname varchar(64) not null,
                        lastname varchar(64) not null,
                        street varchar(80) not null,
                        zipcode varchar(10) not null,
                        city varchar(64) not null,
                        email varchar(64) not null,
                        phone varchar(16) not null,
);
create table order_row(
                          id bigint not null auto_increment PRIMARY KEY,
                          order_id bigint not null,
                          product_id bigint not null,
                          quantity int not null,
                          price decimal(6,2) not null,
                          constraint fk_order_row_order_id foreign key (order_id) references `order`(id),
                          constraint fk_order_row_product_id foreign key (product_id) references product(id)
);