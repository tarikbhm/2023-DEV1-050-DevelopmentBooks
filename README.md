# Getting Started

This microservice aims to calculate the price of the books

Used tech:
Spring boot
Java 17
lombok
H2 for database with script data.sql schema.sql
mvn 3.8.1

DDD architecture
TDD for price calculation

#### Build

`mvn clean install`

#### Run

Just run the main class `KataApplication.java`

#### EndPoints

To get the list of books
curl --location --request GET 'localhost:8080/books'

curl --location --request POST 'localhost:8080/shop/price' \
--header 'Content-Type: application/json' \
--data-raw '[{"bookId": 1, "quantity": 3}]'


#### Modules

app module contains all the controllers, data for requests and responses

domain module contains all business logic and models

infra module contains database access and any outside calls
