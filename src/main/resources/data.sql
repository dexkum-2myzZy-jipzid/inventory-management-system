-- login
-- INSERT INTO USERS(username, password, enabled) VALUES ('user', '{bcrypt}$2a$10$BCGqOZlI6b8gq2M0K8aGVO1pVdAN3Y8RQ2/On8vBWVZGsE7tZ1S1K', 1);
-- INSERT INTO USERS(username, password, enabled) VALUES ('admin', '{bcrypt}$2a$10$BCGqOZlI6b8gq2M0K8aGVO1pVdAN3Y8RQ2/On8vBWVZGsE7tZ1S1K', 1);

-- INSERT INTO AUTHORITIES(username, authority) VALUES ('user', 'ROLE_USER');
-- INSERT INTO AUTHORITIES(username, authority) VALUES ('admin', 'ROLE_ADMIN');

-- inventory
INSERT INTO INVENTORY(name, category, quantity, price) VALUES ('MacBook Pro', 'Electronics', 10, 1299.99);
INSERT INTO INVENTORY(name, category, quantity, price) VALUES ('iPhone', 'Electronics', 20, 699.99);
INSERT INTO INVENTORY(name, category, quantity, price) VALUES ('iPad', 'Electronics', 15, 329.99);
INSERT INTO INVENTORY(name, category, quantity, price) VALUES ('AirPod', 'Electronics', 30, 159.99);
