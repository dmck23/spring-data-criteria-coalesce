CREATE DATABASE TestDB;

USE TestDB;

CREATE TABLE test_table (
    id bigint NULL,
    value decimal(15, 10) NULL
);

INSERT INTO test_table(id,value) VALUES
(1, 53.5670000000),
(2, 3.7891234567),
(3, 4.1234567890),
(4, 2345.1234554321),
(5, 23.0000000000)