DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), cost int, PRIMARY KEY (id));
--INSERT INTO users (name, score) VALUES ('Bob', 80), ('Jack', 80), ('John', 80);