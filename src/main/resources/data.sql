CREATE TABLE person
(
    id         integer      not null,
    name       varchar(255) not null,
    location   varchar(255),
    birth_date timestamp,
    primary key (id)
);

INSERT INTO PERSON
(id,name,location,birth_date)
values(1001,'Ranga','Hyderabad', CURRENT_TIMESTAMP());
INSERT INTO PERSON
(id,name,location,birth_date)
values(1002,'James','New York', CURRENT_TIMESTAMP());
INSERT INTO PERSON
(id,name,location,birth_date)
values(1003,'Peter','Amsterdam', CURRENT_TIMESTAMP());

