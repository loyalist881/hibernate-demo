-- liquibase formatted sql

-- changeset Pavel:1
create schema if not exists demojoin;

-- changeset Pavel:2
create table if not exists demojoin.persons
(
    id           bigserial primary key,
    name         varchar(50) not null,
    surname      varchar(50) not null,
    age          int not null,
    city         varchar(50) not null,
    phone_number varchar(20),
    email        varchar(100)
);