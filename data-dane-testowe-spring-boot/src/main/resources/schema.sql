create table users(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    age INT
);

create table address(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    city VARCHAR(200),
    street VARCHAR(200),
    home_no VARCHAR(5),
    flat_no VARCHAR(5)
);
