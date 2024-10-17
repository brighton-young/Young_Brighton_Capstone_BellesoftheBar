CREATE TABLE services
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    service_name  VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    price_per_hour DOUBLE NOT NULL,
    CONSTRAINT pk_services PRIMARY KEY (id)
);