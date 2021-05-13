create table products
(
    id          serial NOT NULL primary key,
    name        varchar(120) NOT NULL,
    description text,
    imgLink     text,
    imgLink2    text,
    color       varchar(120),
    price       int
);
