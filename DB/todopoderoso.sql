DROP DATABASE IF EXISTS chiche;

CREATE DATABASE IF NOT EXISTS chiche;

CREATE TABLE chiche.cakes (
    id bigint(20) NOT NULL,
    biscuit varchar(255) DEFAULT NULL,
    coverage varchar(255) DEFAULT NULL,
    design varchar(255) DEFAULT NULL,
    filling varchar(255) DEFAULT NULL,
    finish bit(1) NOT NULL,
    ordered_at datetime DEFAULT NULL,
    shape varchar(255) DEFAULT NULL,
    size varchar(255) DEFAULT NULL,
    subtotal float DEFAULT NULL,
    total float DEFAULT NULL
) ENGINE = InnoDB;

CREATE TABLE chiche.orders (
    id bigint(20) NOT NULL,
    cake_id bigint(20) DEFAULT NULL,
    user_id bigint(20) DEFAULT NULL
) ENGINE = InnoDB;

CREATE TABLE chiche.prices (
    id bigint(20) NOT NULL,
    description varchar(255) DEFAULT NULL,
    price float DEFAULT NULL,
    type varchar(255) DEFAULT NULL
) ENGINE = InnoDB;

CREATE TABLE chiche.users (
    id bigint(20) NOT NULL,
    email varchar(255) DEFAULT NULL,
    password varchar(255) DEFAULT NULL,
    role varchar(255) DEFAULT NULL,
    username varchar(255) DEFAULT NULL
) ENGINE = InnoDB;

ALTER TABLE
    chiche.cakes
ADD
    PRIMARY KEY (id);

ALTER TABLE
    chiche.orders
ADD
    PRIMARY KEY (id),
ADD
    KEY FKqby787fxeqpqe0sdlkwevbfvv (cake_id),
ADD
    KEY FK32ql8ubntj5uh44ph9659tiih (user_id);

ALTER TABLE
    chiche.prices
ADD
    PRIMARY KEY (id);

ALTER TABLE
    chiche.users
ADD
    PRIMARY KEY (id);

ALTER TABLE
    chiche.cakes
MODIFY
    id bigint(20) NOT NULL AUTO_INCREMENT;

ALTER TABLE
    chiche.orders
MODIFY
    id bigint(20) NOT NULL AUTO_INCREMENT;

ALTER TABLE
    chiche.prices
MODIFY
    id bigint(20) NOT NULL AUTO_INCREMENT;

ALTER TABLE
    chiche.users
MODIFY
    id bigint(20) NOT NULL AUTO_INCREMENT;

ALTER TABLE
    chiche.orders
ADD
    CONSTRAINT FK32ql8ubntj5uh44ph9659tiih FOREIGN KEY (user_id) REFERENCES chiche.users (id),
ADD
    CONSTRAINT FKqby787fxeqpqe0sdlkwevbfvv FOREIGN KEY (cake_id) REFERENCES chiche.cakes (id);

-- Insercciones
INSERT INTO
    chiche.users (id, email, password, role, username)
VALUES
    (
        NULL,
        'admin@mail.com',
        '$2a$10$mjoxaZ/GPIeIUEt07S6fYugKTJE6xmtVglsauBTkxK1/F2ysdCWHu',
        'admin',
        'Adolfo Juarez'
    ),
    (
        NULL,
        'client@mail.com',
        '$2a$10$LmH0EY9wWT2bvxzoGpNqkOqum.0IcdCt2y2pKX30bGx2QoNUl9c9e',
        'client',
        'Diego Carmona'
    );

    -- taco1 y taco2

INSERT INTO
    chiche.prices (id, description, price, type)
VALUES
    (NULL, 'chocolate', '45', 'bizcocho'),
    (NULL, 'vainilla', '47', 'bizcocho'),
    (NULL, 'funfetti', '52', 'bizcocho'),
    (NULL, 'red velvet', '55', 'bizcocho'),
    (NULL, 'caf??', '56', 'bizcocho'),
    (NULL, 'oreo', '46', 'bizcocho'),
    (NULL, 'mermelada de fresa', '35', 'relleno'),
    (NULL, 'cajeta', '32', 'relleno'),
    (NULL, 'bet??n de caf??', '37', 'relleno'),
    (NULL, 'bet??n de chocolate', '36', 'relleno'),
    (NULL, 'bet??n de vainilla', '36', 'relleno'),
    (NULL, 'bet??n de cereza', '39', 'relleno'),
    (NULL, 'ganage de Hersheys', '43', 'relleno'),
    (NULL, 'bet??n de queso crema', '41', 'relleno'),
    (NULL, 'bet??n de oreo', '41', 'relleno'),
    (NULL, 'bet??n de mantequilla', '39', 'cobertura'),
    (NULL, 'crema pastelera', '36', 'cobertura'),
    (NULL, 'impresiones', '34', 'dise??o'),
    (NULL, 'con crema de mantequilla', '36', 'dise??o'),
    (NULL, 'circular', '0', 'forma'),
    (NULL, 'corazon', '23', 'forma'),
    (NULL, 'peque??o', '100', 'tama??o'),
    (NULL, 'mediano', '200', 'tama??o'),
    (NULL, 'grande', '300', 'tama??o');

INSERT INTO
    chiche.cakes (
        id,
        biscuit,
        coverage,
        design,
        filling,
        finish,
        ordered_at,
        shape,
        size,
        subtotal,
        total
    )
VALUES
    (
        NULL,
        'chocolate',
        'bet??n de mantequilla',
        'impresiones',
        'cajeta',
        0,
        '2022-11-04 02:41:52',
        'circular',
        'grande',
        '450',
        '522'
    );