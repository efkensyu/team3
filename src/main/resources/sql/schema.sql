CREATE TABLE login_tbl (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) UNIQUE NOT NULL
--    password VARCHAR(255) NOT NULL
);

CREATE TABLE team3_syohin_tbl (
 id INT PRIMARY KEY AUTO_INCREMENT,
 date DATE NOT NULL,
 category VARCHAR(100) NOT NULL,
 price INT NOT NULL,
 amount INT NOT NULL,
 result INT AS (price * amount)
);