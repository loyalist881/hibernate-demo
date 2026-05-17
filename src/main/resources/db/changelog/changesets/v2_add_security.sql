-- liquibase formatted sql

-- changeset Pavel:4
alter table demojoin.persons
add column password varchar(255),
add column role varchar(50);