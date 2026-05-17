-- liquibase formatted sql

-- changeset Pavel:3
insert into demojoin.persons
(id, name, surname, age, city, phone_number, email, password, role)
values
    (1, 'Pavel', 'Sokolov', 23, 'Novosibirsk', '111-111', 'pavel@test.com', '{noop}123', 'ROLE_USER'),
    (2, 'Anna', 'Ivanova', 28, 'Moscow', '222-222', 'anna@test.com', '{noop}123', 'ROLE_USER'),
    (3, 'Ivan', 'Smirnov', 35, 'Moscow', '333-333', 'ivan@test.com', '{noop}123', 'ROLE_USER')
on conflict (id) do nothing;