-- For generating UUID
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Catalog Tables
CREATE TABLE IF NOT EXISTS category(
	category_id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	category_name VARCHAR(100) NOT NULL
);


CREATE TABLE IF NOT EXISTS payment_type(
	payment_type_id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY, 
	payment_type_name VARCHAR(100) NOT NULL,
	enabled BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS payment_status(
	payment_status_id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY, 
	payment_status VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS ticket(
	ticket_id UUID NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
	total_sale NUMERIC(10,2) NOT NULL,
	generation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS user_role(
	user_role_id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	user_role_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_type( -- Natural or Company
	user_type_id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	user_type_name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS provider(
	provider_id UUID NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
	provider_name VARCHAR(256) NOT NULL,
	phone_number VARCHAR(20) NULL,
	email VARCHAR(50) NULL
);

-- First level FK

CREATE TABLE IF NOT EXISTS subcategory(
	subcategory_id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	subcategory_name VARCHAR(100) NOT NULL,
	category_id INT NOT NULL,
	CONSTRAINT fk_category FOREIGN KEY(category_id) REFERENCES category(category_id)
);

-- Two or more FK

CREATE TABLE IF NOT EXISTS product(
	product_id UUID NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
	product_name VARCHAR(256) NOT NULL,
	subcategory_id int NOT NULL,
	quantity int NOT NULL DEFAULT 0,
	price NUMERIC(10,2) NOT NULL,
	provider_id UUID NOT NULL,
	description VARCHAR(300) NULL,
	CONSTRAINT fk_subcategory FOREIGN KEY(subcategory_id) REFERENCES subcategory(subcategory_id),
	CONSTRAINT fk_provider FOREIGN KEY(provider_id) REFERENCES provider(provider_id)
);

CREATE TABLE IF NOT EXISTS users(
	user_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
	user_name VARCHAR(100) NOT NULL, 
	lastname VARCHAR(100),
	doc VARCHAR(100), 
	phone_number VARCHAR(50),
	email VARCHAR(50),
	birthdate DATE, 
	user_type_id INT NOT NULL,
	role_id INT NOT NULL,
	CONSTRAINT fk_user_type FOREIGN KEY (user_type_id) REFERENCES user_type(user_type_id),
	CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES user_role(user_role_id)
);

CREATE TABLE IF NOT EXISTS orders(
	order_id UUID NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
	user_id UUID NOT NULL, 
	ticket_id UUID NOT NULL, 
	order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	payment_status INT NOT NULL, 
	delivery_status INT NOT NULL,
	payment_type_id INT NOT NULL,
	CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
	CONSTRAINT fk_ticket_id FOREIGN KEY (ticket_id) REFERENCES ticket(ticket_id) ,
	CONSTRAINT fk_payment_status FOREIGN KEY (payment_status) REFERENCES payment_status(payment_status_id),
	CONSTRAINT fk_payment_type_id FOREIGN KEY (payment_type_id) REFERENCES payment_type(payment_type_id)
);

CREATE TABLE IF NOT EXISTS order_detail(
	order_detail_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, 
	order_id UUID NOT NULL,
	product_id UUID NOT NULL, 
	quantity FLOAT(2) NOT NULL,
	total NUMERIC(10,2) NOT NULL, 
	discount FLOAT(2) DEFAULT 0.0,
	CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES orders(order_id),
	CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES product(product_id)
);