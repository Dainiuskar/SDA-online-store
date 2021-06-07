INSERT into ADDRESS (country, city, street)
values ('Lithuania', 'Kaunas', 'Savanorių'),
       ('Lithuania', 'Vilnius', 'Ozo');

INSERT into USER (firstname, lastname, address_id)
values ('Jonas', 'Jonaitis', 1),
       ('Petras', 'Petraitis', 2);

INSERT into CATEGORY (name)
values ('Clothes');

INSERT into CATEGORY (name, parent_category_id)
values ('Pants', 1),
       ('Sweater', 1);

INSERT into PRODUCT (title, description, category_id, price, product_type)
values ('jeans', 'Levis jeans', 2, 30.5, null),
       ('jeans', 'Levis jeans', 2, 40, null);

INSERT into USER_ACCOUNT (login, password, role, user_id)
values ('User', '$2a$10$46raevv733GZUcZBVml4s.UzETmGIhsG4LfbyddbsyhhSAe5KRFHi', 'USER', 1),
       ('Admin', '$2a$10$46raevv733GZUcZBVml4s.UzETmGIhsG4LfbyddbsyhhSAe5KRFHi', 'ADMIN', 2);
-- password 123