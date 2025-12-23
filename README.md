# Library Management System

A **console-based Library Management System** implemented in **Java** with **MySQL** database integration.  
This project allows you to **add, view, update, and delete books** in a library. It demonstrates **Java OOP principles, JDBC database connectivity, and CRUD operations**.

---

## Features

- Add new books with title and author
- View all books in the library
- Update book details
- Delete books
- Console-based interactive menu
- MySQL database integration using JDBC

---

## Technologies Used

- **Java (JDK 17)**  
- **MySQL**  
- **JDBC (MySQL Connector/J)**  
- **IntelliJ IDEA** (IDE)  

---

## Database Setup

1. Make sure **MySQL server is running**.
2. Run the following SQL script (`library.sql`) to create the database and table:

```sql
CREATE DATABASE IF NOT EXISTS library;
USE library;

CREATE TABLE IF NOT EXISTS books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255)
);
