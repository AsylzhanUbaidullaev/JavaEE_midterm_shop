create table if not exists comments(
    id serial PRIMARY KEY,
    comment text,
    product_id int,
    FOREIGN KEY(product_id) references products(id),
    userid int,
    foreign key(userid) references users(id)
)
