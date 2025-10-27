# 🏦 Bank Management System

A **Full Stack Web Application** built using **Angular**, **Spring Boot**, and **MySQL**.  
This project manages core banking operations such as **Accounts, Deposits, Transactions, and Service Requests** with a user-friendly frontend and a secure backend.

---

## 🚀 Features
- Create, update, and delete bank accounts  
- Manage deposits and transactions  
- Raise and track service requests  
- RESTful APIs for frontend-backend communication  
- Secure database management using MySQL  
- Responsive Angular frontend with clean UI  

---

## 🧠 Tech Stack
**Frontend:** Angular, TypeScript, HTML, CSS, Bootstrap  
**Backend:** Java, Spring Boot, Spring Data JPA, REST API  
**Database:** MySQL  
**Tools:** Spring Tool Suite (STS), Postman, Swagger, VS Code  

---

## ⚙️ How to Run

### 🟢 Backend (Spring Boot)
1. Open backend folder in **STS** or **IntelliJ IDEA**
2. Update `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/bankdb
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
