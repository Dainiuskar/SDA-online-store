INSERT into ADDRESS (country, city, street)
values ('Lithuania', 'Kaunas', 'Savanorių'),
       ('Lithuania', 'Vilnius', 'Ozo');

INSERT into USER (firstname, lastname, address_id)
values ('Jonas', 'Jonaitis', 1),
       ('Petras', 'Petraitis', 2);

INSERT into CATEGORY (name, parent_category_id)
values ('Clothes', null ),
       ('Mens clothes', 1),
       ('Pants', 2),
       ('Casual pants', 3),
       ('Kelnes', 2),
       ('briedas', 2 );

INSERT into PRODUCT (title, description, category_id, price, product_type)
values ('jeans', 'Levis jeans', 4, 30.5, null),
       ('jeans', 'Levis jeans', 4, 40, null);

INSERT into USER_ACCOUNT (login, password, role, user_id)
values ('User', '$2a$10$46raevv733GZUcZBVml4s.UzETmGIhsG4LfbyddbsyhhSAe5KRFHi', 'USER', 1),
       ('Admin', '$2a$10$46raevv733GZUcZBVml4s.UzETmGIhsG4LfbyddbsyhhSAe5KRFHi', 'ADMIN', 2);
-- password 123

INSERT into ORDER_LINE (number_of_products, product_price, product_id)
values (2, 30.50, 1),
       (3, 40.00, 2)
