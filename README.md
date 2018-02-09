# Spring Boot Maven Project

## Prerequisites

- jdk1.8.x
- mysql
- maven 3+

## Build the application

```
git clone https://github.com/Heshan-Sandamal/order-manager

cd order-manager/

mvn clean install
```
 

## Create databases

create a new database using,

```
CREATE DATABASE sysco;
```

change the application.properties file for following configurations

```
*spring.jpa.hibernate.ddl-auto=create - for create the schema and destroy previous data

*spring.jpa.hibernate.ddl-auto=update - for update the schema if necessary.
```

## Run the application

```
mvn spring-boot:run

```

The application is deployed at localhost:8080
