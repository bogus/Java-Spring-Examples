CREATE TABLE products (
id INTEGER NOT NULL PRIMARY KEY,
description varchar(255),
price decimal(15,2)
);

CREATE INDEX products_description ON products(description);

INSERT INTO products (id, description, price) values(1, 'Lamp', 5.78);
INSERT INTO products (id, description, price) values(2, 'Table', 75.29);
INSERT INTO products (id, description, price) values(3, 'Chair', 22.81);

