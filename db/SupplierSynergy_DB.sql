DROP DATABASE IF EXISTS SupplierSynergy;
CREATE DATABASE SupplierSynergy;
USE SupplierSynergy;

CREATE TABLE Supplier
(
  supplier_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  address VARCHAR(250) NOT NULL,
  contact_name VARCHAR(100) NOT NULL,
  contact_email VARCHAR(100) NOT NULL,
  contact_phone CHAR(11) NOT NULL,
  rating NUMERIC(3,2) NOT NULL,
  PRIMARY KEY (supplier_id)
);

CREATE TABLE Product
(
  product_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  description VARCHAR(500) NOT NULL,
  unit_price INT NOT NULL,
  PRIMARY KEY (product_id)
);

CREATE TABLE Supplier_Product
(
  supplier_id INT NOT NULL,
  product_id INT NOT NULL,
  PRIMARY KEY (supplier_id, product_id),
  FOREIGN KEY (supplier_id) REFERENCES Supplier(supplier_id),
  FOREIGN KEY (product_id) REFERENCES Product(product_id)
);
CREATE TABLE Warehouse
(
  warehouse_id INT NOT NULL AUTO_INCREMENT,
  address VARCHAR(250) NOT NULL,
  capacity INT NOT NULL,
  PRIMARY KEY (warehouse_id)
);

CREATE TABLE Employee
(
  employee_id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  Salary INT NOT NULL,
  warehouse_id INT NOT NULL,
  PRIMARY KEY (employee_id),
  FOREIGN KEY (warehouse_id) REFERENCES Warehouse(warehouse_id)
);

CREATE TABLE Retailer
(
  retailer_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  phone CHAR(11) NOT NULL,
  address VARCHAR(250) NOT NULL,
  email VARCHAR(100) NOT NULL,
  PRIMARY KEY (retailer_id)
);

CREATE TABLE Certification
(
  certification_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  authorized_by VARCHAR(100) NOT NULL,

  PRIMARY KEY (certification_id)
);

CREATE TABLE Orders
(
  order_id INT NOT NULL AUTO_INCREMENT,
  status VARCHAR(10) NOT NULL,
  oder_time DATE NOT NULL,
  quantity INT NOT NULL,
  retailer_id INT NOT NULL,
  product_id INT NOT NULL,
  PRIMARY KEY (order_id),
  FOREIGN KEY (retailer_id) REFERENCES Retailer(retailer_id),
  FOREIGN KEY (product_id) REFERENCES Product(product_id)
);

CREATE TABLE Has_Certification
(
  certification_id INT NOT NULL,
  supplier_id INT NOT NULL,
  expires DATE NOT NULL,
  PRIMARY KEY (supplier_id, certification_id),
  FOREIGN KEY (supplier_id) REFERENCES Supplier(supplier_id),
  FOREIGN KEY (certification_id) REFERENCES Certification(certification_id)
);

CREATE TABLE Stored_at
(
  product_id INT NOT NULL,
  warehouse_id INT NOT NULL,
  quantity INT NOT NULL,
  PRIMARY KEY (product_id, warehouse_id),
  FOREIGN KEY (product_id) REFERENCES Product(product_id),
  FOREIGN KEY (warehouse_id) REFERENCES Warehouse(warehouse_id)
);

CREATE TABLE Employee_phone
(
  employee_id INT NOT NULL,
  phone CHAR(11) NOT NULL,
  PRIMARY KEY (phone, employee_id),
  FOREIGN KEY (employee_id) REFERENCES Employee(employee_id)
);