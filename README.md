## **Belles of the Bar - Capstone Project**

Welcome to **Belles of the Bar** — an online booking and event management system for premium bartending services. This project was developed as part of my Java Developer Capstone, demonstrating full-stack development using **Spring Boot** and **Thymeleaf** with a **MySQL** backend.

![Belles of the Bar Logo](src/main/resources/static/images/logo.png)

---

### **Table of Contents**
- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Features](#features)
- [Database Schema](#database-schema)
- [Installation and Setup](#installation-and-setup)
- [Endpoints](#endpoints)
- [Screenshots](#screenshots)
- [Future Improvements](#future-improvements)
- [License](#license)

---

## **Project Overview**
The **Belles of the Bar** project allows customers to:
- Register and log in to the platform.
- Browse available bartending services.
- Create and manage bookings for their events.
- View their event history and status updates via a personalized dashboard.

This project also provides an **admin panel** for administrators to manage bookings, approve or reject event requests, and oversee service offerings.

---

## **Technologies Used**
- **Java 17** (Core backend logic)
- **Spring Boot** (Framework for backend)
- **Spring Data JPA & Hibernate** (Database ORM)
- **Thymeleaf** (Templating engine for frontend)
- **MySQL** (Relational database)
- **Spring Security** (Authentication and authorization)
- **JUnit** (Unit testing framework)
- **Maven** (Dependency management)
- **HTML, CSS, JavaScript** (Frontend design)

---

## **Features**
### **User Features:**
- **Registration & Login:** Users can register and log in to manage their bookings.
- **Service Browsing:** Users can browse available bartending services.
- **Booking Creation:** Users can create bookings, including selecting services and event details.
- **Dashboard:** Users can view all their bookings with status updates.
- **Booking Cancellation:** Users can cancel their bookings if needed.

### **Admin Features:**
- **Admin Panel:** Admins can manage and approve/reject bookings.
- **Service Management:** Admins can add or remove services.

### **Additional Functionality:**
- **Role-based Access Control:** User and Admin roles using Spring Security.
- **Password Hashing:** Passwords are hashed using **BCrypt**.
- **Dynamic Price Calculation:** Total event costs are calculated based on services selected.

---

## **Database Schema**
Below is a simplified version of the **Entity Relationship Diagram (ERD)** for the database.

**Tables:**
- `users`: Stores user credentials and roles.
- `events`: Stores event details.
- `services`: Stores service offerings.
- `bookings`: Links users to events and services.

```text
User (1) --- (M) Booking (M) --- (M) Service
User (1) --- (M) Event
Booking (M) --- (1) Event
```

---

## **Installation and Setup**
Follow these steps to set up the project locally:

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/yourusername/belles-of-the-bar.git
   cd belles-of-the-bar
   ```

2. **Set Up MySQL Database:**
   - Create the database:
     ```sql
     CREATE DATABASE bellesofthebar;
     ```

3. **Update `application.properties`:**
   Open `src/main/resources/application.properties` and update with your MySQL credentials:
   ```properties
   spring.datasource.username=your_mysql_username
   spring.datasource.password=your_mysql_password
   ```

4. **Build the Project with Maven:**
   ```bash
   mvn clean install
   ```

5. **Run the Application:**
   ```bash
   mvn spring-boot:run
   ```

6. **Access the Application:**
   - Open your browser and navigate to: [http://localhost:8080](http://localhost:8080)

---

## **Endpoints**
| **Method** | **Endpoint**            | **Description**                        |
|------------|-------------------------|----------------------------------------|
| `POST`     | `/register`             | Register a new user                    |
| `POST`     | `/login`                | User login                             |
| `GET`      | `/events`               | List all events                        |
| `POST`     | `/events`               | Create a new event                     |
| `GET`      | `/bookings`             | List all bookings                      |
| `POST`     | `/bookings`             | Create a new booking                   |
| `DELETE`   | `/bookings/{id}`        | Delete a booking                       |

---

## **Screenshots**
Here are some screenshots of the application:

1. **Home Page:**
   ![Home Page](src/main/resources/static/images/screenshots/home.png)

2. **Registration Page:**
   ![Registration Page](src/main/resources/static/images/screenshots/registration.png)

3. **User Dashboard:**
   ![User Dashboard](src/main/resources/static/images/screenshots/dashboard.png)

4. **Admin Panel:**
   ![Admin Panel](src/main/resources/static/images/screenshots/admin-panel.png)

---

## **Future Improvements**
Future improvements for the project include:
- Implementing REST API for mobile integration.
- Adding social media login functionality.
- Improving the UI design for better user experience.
- Introducing more analytics and reporting features for administrators.

---

## **License**
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.