# Spring Boot Starter Project

This project is based on a Spring Boot starter tutorial series on YouTube by [Rashmika](https://github.com/Rashmika523/). The tutorial is conducted in Sinhala and consists of four videos.

## Table of Contents

- [Introduction](#introduction)
- [Technologies Used](#technologies-used)
- [Project Setup](#project-setup)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This project is a Spring Boot application that demonstrates the basics of building a RESTful API. It covers various aspects of Spring Boot, including controllers, services, repositories, and exception handling.

## Technologies Used

- Java
- Spring Boot
- Maven
- Lombok
- Swagger

## Project Setup

1. **Clone the repository:**

    ```bash
    git clone https://github.com/RashminaFdo/spring-boot-starter-project.git
    cd spring-boot-starter-project
    ```

2. **Import the project into your IDE:**

    - Open IntelliJ IDEA.
    - Select `File` > `Open` and choose the project directory.

3. **Install dependencies:**

    ```bash
    mvn clean install
    ```

4. **Configure the application properties:**

    Update the `application.properties` file in the `src/main/resources` directory with your database configuration.

## Running the Application

To run the application, use the following command:

```bash
mvn spring-boot:run
```
### The application will start on http://localhost:8080.  

# API Endpoints
_It is recommended to run and test the API endpoints through Swagger. Swagger UI can be accessed at http://localhost:8080/swagger-ui.html._  

## Item Endpoints
1. Save Item:  
  - POST /api/v1/item/save-item
  - Request Body: ItemSaveRequestDTO
2. Update Item:  
  - PUT /api/v1/item/update-item
  - Request Body: ItemSaveRequestDTO
3. Get Item by Name:  
  - GET /api/v1/item/get-item-by-name
  - Query Parameter: name
4. Get All Items:  
  - GET /api/v1/item/get-all-items
5. Delete Item:  
  - DELETE /api/v1/item/delete-item/{id}
  - Path Variable: id
6. Get Items by State:  
  - GET /api/v1/item/get-all-items-by-state
  - Query Parameter: state

    
## Customer Endpoints
1. Save Customer:  
  - POST /api/v1/customer/save-customer
  - Request Body: CustomerSaveRequestDTO
2. Update Customer:  
  - PUT /api/v1/customer/update-customer
  - Request Body: CustomerSaveRequestDTO
3. Get Customer by ID:  
  - GET /api/v1/customer/get-customer-by-id/{id}
  - Path Variable: id
4. Get All Customers:  
  - GET /api/v1/customer/get-all-customers
5. Delete Customer:  
  - DELETE /api/v1/customer/delete-customer/{id}
  - Path Variable: id
6. Get Customers by State:  
  - GET /api/v1/customer/get-all-customers-by-state
  - Query Parameter: state
## Order Endpoints
1. Save Order:
  - POST /api/v1/order/save-order
  - Request Body: OrderSaveRequestDTO
      
# Contributing
**Contributions are not allowed. If you want to make changes, please download and edit a duplicate of the project.** 
### License
This project is licensed under the MIT [https://github.com/remy/mit-license.git](License).
### Contact
For any issues or questions, please email: [Contact Me](mailto:fdo.rashmina@gmail.com?subject=Regarding%20the%20IIT-pos-system-using-Springboot%20repository%20in%20GitHub&body=Type%20your%20question/issue%20here)

