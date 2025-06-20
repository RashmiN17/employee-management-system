# Employee-management-system
A full-stack Employee Management System using Angular and Spring Boot with CRUD operations, department filters, pagination, modals, and responsive UI.

# 👩‍💼 Employee Management System

A full-stack web application for managing employee records, built using **Angular** (frontend) and **Spring Boot** (backend). It supports CRUD operations, department filtering, pagination, search.

---

## 🚀 Technologies Used

### 💻 Frontend
- Angular 17+
- TypeScript
- Bootstrap 5
- Font Awesome
- Reactive Forms
- Angular Material (optional)

### ☕ Backend
- Spring Boot
- Spring MVC
- Spring Data JPA
- MySQL
- Maven

---

## 🔧 Features

- Add, update, view, and delete employee records
- Filter employees by name/designation
- Multi-select department filter
- Pagination for large data
- Responsive UI with Bootstrap
- Confirmation modal for all operations
- Toast notifications for success/failure


---

## 🛠️ Getting Started

### Backend Setup

1. Import the backend project in your IDE (e.g., IntelliJ, Eclipse)
2. Update the MySQL database configuration in `application.properties`
3. Run the Spring Boot application
4. APIs will be available at: `http://localhost:8080/employees`

### Frontend Setup

```bash
cd employee-management-system
npm install
npm install bootstrap@5 font-awesome @angular/material @angular/cdk ngx-spinner ngx-toastr ng-multiselect-dropdown @ng-bootstrap/ng-bootstrap

ng serve


### Database Setup
 Default Login
You can login using the default admin credentials:

Username: admin

Password: admin@123

OR you can insert your own user in the users table.

###Database Structure
👨‍💼 employee
| Column          | Type    | Notes                  |
| --------------- | ------- | ---------------------- |
| emp\_id         | INT     | Autoincrement Primary Key            |
| emp\_name       | VARCHAR | Employee Name          |
| salary          | DOUBLE  | Employee Salary        |
| designation\_id | INT     | FK → `designation(id)` |
| dept\_id        | INT     | FK → `department(id)`  |

🏢 department
| Column | Type    | Notes           |
| ------ | ------- | --------------- |
| id     | INT     | Autoincrement  Primary Key     |
| name   | VARCHAR | Department Name |
| code   | VARCHAR | Department Code |


🧑‍💼 designation
| Column | Type    | Notes            |
| ------ | ------- | ---------------- |
| id     | INT     | Autoincrement Primary Key      |
| name   | VARCHAR | Designation Name |


🔐 users
| Column   | Type    | Notes                               |
| -------- | ------- | ----------------------------------- |
| id       | INT     | Autoincrement Primary Key                         |
| username | VARCHAR | Login username                      |
| password | VARCHAR | Login password (hashed recommended) |


 
