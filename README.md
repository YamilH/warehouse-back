# Warehouse-Back

## Overview

This project is the back-end part of a fullstasck project.

The DOM Javascript clint-end most recent version is in this repository: https://github.com/YamilH/warehouse-front


## Back Project Structure

The project follows a specific directory structure to organize the server-side code. Here's an overview of the directory structure:

```.
├─── warehouse
│       └──  src/main
│       │       ├─── java/ar/com/warehouse
│       │       │           ├─── controllers
│       │       │           │        ├─── AppBaseController.java
│       │       │           │        ├─── NewProductController.java
│       │       │           │        └─── ProductRequest.java
│       │       │           ├─── entity
│       │       │           │        ├─── Product.java
│       │       │           │        └─── ProductMain.java
│       │       │           ├─── filters
│       │       │           │        └─── CorsFilter.java
│       │       │           └─── repository
│       │       │                    ├─── ConnectionsManager.java
│       │       │                    ├─── MainProductRepository.java
│       │       │                    ├─── MySQLProductRepository.java
│       │       │                    └─── ProductRepository.java
│       │       └─── webapp
│       │              └─── index.html
│       ├─── .gitignore
│       └─── pom.xml
└─── README.md
```


## Deployment

The deploy is currently not available at the moment, but here is a testing video of the fullstack project.

(video will be here soon)


## Conclusion

With Warehouse, the idea was to create a simulated warehouse management, focusing on building the backend with Java and establishing the necessary connections to make it a fullstack application where anybody can make changes, the typical CRUD functionalities
