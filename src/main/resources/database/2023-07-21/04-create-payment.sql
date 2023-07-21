--liquibase formatted sql
--changeset amroczkowski:10

create table payment(
                        id bigint not null auto_increment PRIMARY KEY,
                        name varchar(64) not null,
                        type varchar(32) not null,
                        default_payment boolean default false,
                        note text
);
insert into payment(id, name, type, default_payment, note)
values (1, 'Bank transfer ', 'BANK_TRANSFER', true, 'Please make a transfer to the account:\n00 0000 0000 0000 0000 0000 0000\n in the title please enter the order number');