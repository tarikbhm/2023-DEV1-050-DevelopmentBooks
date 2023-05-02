CREATE TABLE IF NOT EXISTS book (
    `id` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR(255) NOT NULL,
    `author` VARCHAR(255) NOT NULL,
    `price` DECIMAL(10, 2),
    `year_release` INT NOT NULL,
    `img_url` VARCHAR(255) NOT NULL
    );