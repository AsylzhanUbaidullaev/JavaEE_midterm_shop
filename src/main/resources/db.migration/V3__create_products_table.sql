create table products
(
    id          int(3) NOT NULL AUTO_INCREMENT,
    name        varchar(120) NOT NULL,
    description varchar(220) NOT NULL,
    color       varchar(120),
    price       double (120)
    PRIMARY KEY (id)
);
