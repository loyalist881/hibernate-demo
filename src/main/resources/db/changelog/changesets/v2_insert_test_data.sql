-- liquibase formatted sql

-- changeset Pavel:3
insert into demojoin.persons
(id, name, surname, age, city, phone_number)
values (1, 'Pavel', 'Sokolov', 23, 'Novosibirsk', '111-111'),
       (2, 'Anna', 'Ivanova', 28, 'Moscow', '222-222'),
       (3, 'Ivan', 'Smirnov', 35, 'Moscow', '333-333')
on conflict (id) do nothing;