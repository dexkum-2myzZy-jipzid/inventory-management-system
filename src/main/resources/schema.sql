-- -- create users & authorities table
-- create table users(
-- 	username varchar_ignorecase(50) not null primary key,
-- 	password varchar_ignorecase(50) not null,
-- 	enabled boolean not null
-- );

-- create table authorities (
-- 	username varchar_ignorecase(50) not null,
-- 	authority varchar_ignorecase(50) not null,
-- 	constraint fk_authorities_users foreign key(username) references users(username)
-- );
-- create unique index ix_auth_username on authorities (username,authority);

-- create inventory table
create table INVENTORY(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    category VARCHAR(255),
    quantity INT,
    price DOUBLE
);
