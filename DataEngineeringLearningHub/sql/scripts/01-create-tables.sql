-- Drop if exists (for re-running)
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customers;

-- Customers table
CREATE TABLE customers (
    customer_id INTEGER PRIMARY KEY,
    name        TEXT NOT NULL,
    city        TEXT,
    country     TEXT
);

-- Orders table
CREATE TABLE orders (
    order_id    INTEGER PRIMARY KEY,
    customer_id INTEGER,
    order_date  DATE,
    amount      REAL,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

-- Sample data
INSERT INTO customers VALUES
(1, 'Alice', 'Mumbai', 'India'),
(2, 'Bob', 'Delhi', 'India'),
(3, 'Charlie', 'New York', 'USA'),
(4, 'Diana', 'London', 'UK');

INSERT INTO orders VALUES
(101, 1, '2025-01-15', 2500),
(102, 1, '2025-02-20', 1800),
(103, 2, '2025-03-10', 3200),
(104, 3, '2025-04-05', 999);