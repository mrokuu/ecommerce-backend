--liquibase formatted sql
--changeset amroczkowski:5

CREATE TABLE review (
                        id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        product_id BIGINT NOT NULL,
                        author_name VARCHAR(60) NOT NULL,
                        content TEXT
);

