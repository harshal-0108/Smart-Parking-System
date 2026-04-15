# 🚗 Smart Parking System

## 📌 Project Overview

The Smart Parking System is a web-based application developed to automate and manage parking operations efficiently. The system helps in managing vehicle entry, parking slot allocation, and vehicle exit while maintaining a complete record of parking activities.

This project is built using **Spring Boot (Java)** for backend development, **MySQL** for database management, and **HTML, Bootstrap, and Thymeleaf** for frontend design.

The main goal of this system is to reduce manual work, avoid confusion in parking management, and provide an organized way to handle parking data.

## 🎯 Objectives

* To automate parking slot allocation
* To manage vehicle entry and exit efficiently
* To maintain parking history records
* To reduce manual errors in parking systems
* To provide a simple and user-friendly interface

---

## 🛠️ Technologies Used

### 🔹 Backend

* Java
* Spring Boot
* Spring Data JPA

### 🔹 Frontend

* HTML
* CSS
* Bootstrap
* Thymeleaf

### 🔹 Database

* MySQL

### 🔹 Tools

* Eclipse IDE
* Maven
* MySQL Workbench

---

## 🏗️ Project Structure

The project follows a layered architecture:

### 1. Entity Layer

Contains classes that represent database tables.

Example:

* `Vehicle`
* `ParkingSlot`
* `ParkingRecord`
* `User`

These classes are annotated using JPA annotations like `@Entity`, `@Id`, etc.

---

### 2. Repository Layer

Handles database operations using Spring Data JPA.

Example:

* `VehicleRepository`
* `ParkingSlotRepository`
* `ParkingRecordRepository`
* `UserRepository`

These interfaces extend `JpaRepository` to perform CRUD operations automatically.

---

### 3. Controller Layer

Handles HTTP requests and contains the main business logic.

Example:

* Adding a vehicle
* Assigning a parking slot
* Exiting a vehicle
* Displaying records

---

### 4. Frontend (Templates)

Located in `src/main/resources/templates`

Includes:

* `index.html` (Dashboard)
* `vehicles.html`
* `slots.html`
* `records.html`
* `login.html`

Thymeleaf is used to dynamically display data from the backend.

---

## ⚙️ Features of the System

### 🚗 Add Vehicle

Users can enter vehicle details which are stored in the database.

### 🅿️ Assign Parking Slot

The system automatically assigns the first available slot to the vehicle.

### 🚪 Exit Vehicle

When a vehicle exits:

* Slot becomes available
* Entry and exit time is recorded

### 📊 Parking Records

All parking history is stored and displayed in a tabular format.

### 🔐 Login System

Basic authentication using username and password.

---

## 🔄 Workflow of the System

1. User logs into the system
2. Dashboard is displayed
3. User adds a vehicle
4. System assigns available parking slot
5. Vehicle occupies slot
6. When vehicle exits:

   * Slot is freed
   * Record is stored
7. User can view all records anytime

---

## 🧠 Code Explanation (Important Modules)

### 🔹 Main Class

Starts the Spring Boot application using embedded Tomcat server.

### 🔹 Entity Classes

Define structure of database tables using JPA annotations.

### 🔹 Repository Interfaces

Provide automatic database operations without writing SQL queries.

### 🔹 Controller Class

Handles logic like:

* Saving vehicle data
* Assigning slots
* Managing exit process

### 🔹 HTML Pages

Provide user interface for interacting with the system.

---

## 💡 Advantages

* Reduces manual work
* Efficient slot management
* Maintains parking history
* User-friendly interface
* Cost-effective solution

---

## ⚠️ Limitations

* No real-time sensor integration
* Basic login security
* No online booking feature
* Depends on system availability

---

## 🚀 Future Enhancements

* Online parking slot booking
* Payment integration
* IoT-based slot detection
* Advanced security features
* Mobile application support

---

## 📌 Conclusion

The Smart Parking System provides an efficient and automated solution for parking management. It demonstrates the use of full-stack development technologies and helps in solving real-world parking problems effectively.

---

## 👨‍💻 Author

Developed as part of academic project.
