 **Library Management System**
A Spring Boot REST API for managing users and books with role-based access and basic security.

**Features**
- User registration and login
- Role-based authorization (USER / ADMIN)
- Secure password storage with BCrypt
- CRUD operations for users
- Basic Spring Security integration
  
**Tech Stack**
- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- PostgreSQL / MySQL
- Maven
- 
 **Architecture Overview**
- Controller layer handles HTTP requests
- Service layer contains business logic
- Repository layer interacts with the database
- Spring Security manages authentication and authorization
- 
  **Security**
- Passwords are stored as BCrypt hashes
- Authentication is handled by Spring Security
- User roles are stored in the database
- Endpoints are protected based on user roles
   API Endpoints

| Method | Endpoint | Description | Access |
|------|--------|------------|--------|
| POST | /auth/register | Register user | Public |
| POST | /auth/login | Login | Public |
| GET | /users | Get all users | ADMIN |
| PUT | /users/{id} | Update user | ADMIN |

**What I Learned**
- Implementing basic security with Spring Security
- Working with password hashing
- Role-based access control
- Structuring a layered backend application
