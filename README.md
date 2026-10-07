# Student Management System

A console-based Student Management System built using **Java 25, JDBC, Maven, and MySQL**.

This project demonstrates how a Java application connects to a MySQL database using JDBC and performs basic **CRUD (Create, Read, Update, Delete)** operations.

---

##  Project Overview

The Student Management System allows users to manage student records through a simple console-based menu.

Users can:

- Add a new student
- View all students
- Search for a student by ID
- Update student details
- Delete a student
- Exit the application

The project was developed to practice **Core Java, JDBC, SQL, PreparedStatement, exception handling, and Maven**.

---

##  Features

### 1. Add Student

Add a student with:

- Name
- Email
- Course
- Marks

The application validates required fields and handles duplicate email addresses.

### 2. View All Students

Displays all students stored in the MySQL database.

### 3. Search Student

Search for a student using their unique ID.

### 4. Update Student

Update the following student details:

- Name
- Email
- Course
- Marks

### 5. Delete Student

Delete a student record using the student's ID.

### 6. Input Validation

The application handles invalid inputs such as:

- Empty name
- Empty email
- Non-existing student ID
- Duplicate email

---

## ️ Technologies Used

| Technology | Purpose |
|---|---|
| Java 25 | Application development |
| JDBC | Java-Database connectivity |
| MySQL | Database |
| Maven | Dependency and build management |
| IntelliJ IDEA | Development environment |
| Git & GitHub | Version control |

---

##  Project Structure

```text
JDBC_Project/
│
├── src/
│   └── main/
│       └── java/
│           └── org.example/
│               ├── Config/
│               │   └── DBConfig.java
│               │
│               ├── Student.java
│               ├── StudentService.java
│               └── Main.java
│
├── .gitignore
├── pom.xml
└── README.md
```

---

##  Database Setup

### 1. Create the Database

Open MySQL and run:

```sql
CREATE DATABASE JDBC_Project;
```

Select the database:

```sql
USE JDBC_Project;
```

### 2. Create the Students Table

Run the following SQL query:

```sql
CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    course VARCHAR(100) NOT NULL,
    mark DOUBLE
);
```

---

##  Database Table

The `students` table contains the following columns:

| Column | Data Type | Constraint | Description |
|---|---|---|---|
| `id` | INT | Primary Key, Auto Increment | Unique student ID |
| `name` | VARCHAR(100) | NOT NULL | Student name |
| `email` | VARCHAR(100) | UNIQUE, NOT NULL | Student email |
| `course` | VARCHAR(100) | NOT NULL | Student course |
| `mark` | DOUBLE | — | Student marks |

---

##  JDBC Configuration

The application connects to MySQL using JDBC.

### JDBC URL

```text
jdbc:mysql://localhost:3306/JDBC_Project
```

Configure your local MySQL connection details in `DBConfig.java`.

Example:

```java
String url = "jdbc:mysql://localhost:3306/JDBC_Project";
String username = "YOUR_USERNAME";
String password = "YOUR_PASSWORD";
```

> **Important:** Never commit your actual MySQL password or other sensitive credentials to GitHub.

---

##  Maven Configuration

The project uses Maven for dependency and build management.

### MySQL JDBC Driver

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>9.7.0</version>
</dependency>
```

### Java Version

The project uses **Java 25**:

```xml
<maven.compiler.release>25</maven.compiler.release>
```

---

## ▶️ How to Run

### 1. Clone the Repository

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```
## 2 Environment Variables

Before running the application, configure these environment variables:

DB_URL=jdbc:mysql://localhost:3306/JDBC_Project
DB_USERNAME=your_mysql_username
DB_PASSWORD=your_mysql_password

### 3. Open the Project

Open the cloned project in IntelliJ IDEA.

### 4. Configure MySQL

Make sure:

- MySQL Server is running.
- The `JDBC_Project` database exists.
- The `students` table exists.
- Your local MySQL credentials are configured.

### 5. Build the Project

Open the terminal in the project directory and run:

```bash
mvn clean package
```

A successful build should display:

```text
BUILD SUCCESS
```

### 6. Run the Application

Run the `main` class from IntelliJ IDEA.

The application will display a menu similar to:

```text
---------- Student Management System ----------
1. Add Student
2. View All Student
3. Search Student
4. Update Student
5. Delete Student
6. Exit

Enter your choice:
```

---

##  Testing

The application was manually tested for the following scenarios.

### CRUD Operations

- Add student
- View all students
- Search student
- Update student
- Delete student

### Validation and Error Handling

- Empty name
- Empty email
- Duplicate email
- Non-existing student ID
- Invalid menu choice
- Database constraint errors

### Build Verification

The project was verified using:

```bash
mvn clean package
```

Result:

```text
BUILD SUCCESS
```

All planned functional test cases passed successfully.

---

## JDBC Concepts Demonstrated

This project demonstrates the use of:

- `Connection`
- `DriverManager`
- `PreparedStatement`
- `ResultSet`
- `executeQuery()`
- `executeUpdate()`
- `SQLException`
- Try-with-resources
- Parameterized SQL queries
- CRUD operations
- MySQL database connectivity

---

##  Future Improvements

Possible improvements for future versions:


- Add stronger input validation
- Add sorting and filtering
- Add proper logging
- Add a graphical user interface
- Convert the application into a REST API using Spring Boot
- Improve application architecture
- Move database credentials to environment variables

---

##  Author

**Avinash Dhakane**
