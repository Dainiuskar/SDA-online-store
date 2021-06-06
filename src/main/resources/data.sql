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

