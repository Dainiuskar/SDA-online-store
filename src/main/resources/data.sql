INSERT into ADDRESS (country, city, street)
values ('Lithuania', 'Kaunas', 'Savanorių'),
       ('Lithuania', 'Vilnius', 'Ozo');

INSERT into USER (firstname, lastname, address_id)
values ('Jonas', 'Jonaitis', 1),
       ('Petras', 'Petraitis', 2);

INSERT into CATEGORY (name, parent_category_id)
values ('Clothes', null),
       ('Mens clothes', 1),
       ('Pants', 2),
       ('Casual pants', 3);

INSERT into PRODUCT (title, description, category_id, price, product_type)
values ('jeans', 'Levis jeans', 4, 30.5, null),
       ('jeans', 'Levis jeans', 4, 40, null)


