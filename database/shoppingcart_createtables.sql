Drop table if exists PaymentMethod;
Drop table if exists OrderConfirmation;
Drop table if exists ShoppingCart;
Drop table if exists Inventory;
Drop table if exists StateSalesTax;
Drop table if exists Users;
Drop table if exists Address;

CREATE TABLE `StateSalesTax` (
`state_id` int(11) NOT NULL,
`state_initial` varchar(2) DEFAULT NULL,
`state_name` varchar(20) DEFAULT NULL,
`state_tax_rate` double DEFAULT NULL,
PRIMARY KEY (`state_id`)
);

CREATE TABLE Address (
`address_id` int(20) NOT NULL AUTO_INCREMENT,
`shipping_address` varchar(200) DEFAULT NULL,
`city` varchar(50) DEFAULT NULL,
`state` varchar(2) DEFAULT NULL,
`zip_code` varchar(5) DEFAULT NULL,
CONSTRAINT address_PK
  PRIMARY KEY (address_id)
);

CREATE TABLE `Inventory` (
`product_id` int(11) NOT NULL AUTO_INCREMENT,
`product_name` varchar(100) DEFAULT NULL,
`product_department` varchar(100) DEFAULT NULL,
`product_price` double DEFAULT NULL,
`initial_quantity` int(11) DEFAULT NULL,
`stock_quantity` int(11) DEFAULT NULL,
`sold_units` int(11) DEFAULT NULL,
PRIMARY KEY (`product_id`)
);

CREATE TABLE `Users` (
`user_id` int(20) NOT NULL AUTO_INCREMENT,
`user_name` varchar(25) DEFAULT NULL,
`address_id` int(20),
`email` varchar(50) DEFAULT NULL,
CONSTRAINT `user_PK`
  PRIMARY KEY (`user_id`),
CONSTRAINT `address_FK`
  FOREIGN KEY (`address_id`)
    REFERENCES `Address`(`address_id`)
);

CREATE TABLE `ShoppingCart` (
`cart_items_id` int(11) NOT NULL AUTO_INCREMENT,
`user_id` int(20) DEFAULT NULL,
`product_id` int(11) DEFAULT NULL,
CONSTRAINT `cart_items_PK`
  PRIMARY KEY (`cart_items_id`),
CONSTRAINT `product_FK`
  FOREIGN KEY (`product_id`)
  REFERENCES `Inventory`(`product_id`),
CONSTRAINT `user_FK`
  FOREIGN KEY (`user_id`)
  REFERENCES `Users`(`user_id`)
);

CREATE TABLE `OrderConfirmation` (
`order_id` int(11) NOT NULL AUTO_INCREMENT,
`user_ID` int(20) DEFAULT NULL,
`final_price` double DEFAULT NULL,
`purchase_date` date DEFAULT NULL,
PRIMARY KEY (`order_id`),
CONSTRAINT `user_FK2`
  FOREIGN KEY (`user_id`)
  REFERENCES `Users`(`user_id`)
);

CREATE TABLE `PaymentMethod` (
`payment_id` int(11) NOT NULL AUTO_INCREMENT,
`user_id` int(20) DEFAULT NULL,
`card_number` varchar(16) DEFAULT NULL,
`payment_method_type` varchar(50) DEFAULT NULL,
PRIMARY KEY (`payment_id`),
CONSTRAINT `user_FK3`
  FOREIGN KEY (`user_id`)
  REFERENCES `Users`(`user_id`)
);
