
# POS System API

This API is designed to manage the core functionalities of a Point-of-Sale (POS) system, including managing customers, items, and orders. The API is built using the Spring Framework and follows a RESTful architecture.

## API Documentation
https://documenter.getpostman.com/view/36176457/2sAXxTbVum

## Features

* Customer Management: Add, update, delete, and retrieve customers.

* Item Management: Manage inventory, including adding, updating, and deleting items, and retrieving item information.

* Order Management: Place orders, retrieve order details, and update item quantities after placing orders.

## API Endpoints

All API endpoints are prefixed with api/v1/.

### Customer Endpoints


* POST	/api/v1/customer	Add a new customer

* GET	/api/v1/customer/{id}	Get a customer by ID

* PUT	/api/v1/customer	Update customer details

* DELETE	/api/v1/customer/{id}	Delete a customer

* GET	/api/v1/customers	Get all customers

### Item Endpoints


* POST	/api/v1/item	Add a new item

* GET	/api/v1/item/{id}	Get item details by ID

* PUT	/api/v1/item	Update item details

* DELETE	/api/v1/item/{id}	Delete an item

* GET	/api/v1/items	Get all items

### Order Endpoints


* POST	/api/v1/order	Place a new order

* GET	/api/v1/order/{id}	Get order details by ID

* GET	/api/v1/orders	Get all orders

## Technologies Used

* Framework: Spring

* Database: MySQL

* ORM: Hibernate (JPA)

* JSON: Jackson for request and response handling

* Dependency Management: Maven

* Java Version: 21

## Setup and Installation

#### 1.Clone the repository

`git clone` https://github.com/glen654/POS-API-Spring.git

#### 2.Navigate to the project directory

`cd` `POS-API-Spring`

#### 3.Build and run the application

`mvn` `clean install`


## License

This project is licensed under the [LICENSE.txt](LICENSE.txt) MIT License.