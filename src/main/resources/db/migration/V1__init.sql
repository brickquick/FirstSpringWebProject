DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), cost bigint, PRIMARY KEY (id));
INSERT INTO products (title, cost) VALUES
('Milk', 80),
('Bread', 10),
('Banana', 20),
('Orange', 30),
('Juice', 90),
('Beer', 80),
('Crisps', 80),
('Eggs', 50),
('Gum', 50),
('Biscuits', 80),
('Wine', 500),
('Candies', 150),
('Lemon', 80),
('Watermelon', 100),
('Yogurt', 80),
('Nuts', 80),
('Potatoes', 55),
('Cucumbers', 60),
('Salad', 50),
('Sausages', 200);
