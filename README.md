# 🚀 ConnectionPoolApplication

A Spring Boot project demonstrating how to **implement and use a Custom Connection Pool** for managing database connections manually — without relying on third-party libraries like HikariCP.

This project is built using **JDBC** and **H2 In-Memory Database** to give you a clear understanding of how connection pooling works at a low level.

---

## 📌 Project Highlights

- ✅ Custom Connection Pool (configurable pool size)
- ✅ Manual connection acquire & release logic
- ✅ JDBC-based Repository Layer using raw SQL queries
- ✅ In-memory H2 Database (no setup required)
- ✅ Clean architecture: `Controller → Repository`
- ✅ REST APIs tested using Postman

---

## 🏗️ Architecture

```text
+------------+       +---------------+        +------------------------+
|  Controller| <---> | Repository     | <---> | CustomConnectionPool   |
+------------+       +---------------+        +------------------------+
                                           |
                                           |--> DB (H2 In-Memory)

🛠️ Tech Stack
Framework -	Spring Boot
Language -	Java
Build Tool -	Maven
Database -	H2 (In-Memory)
Data Access	- JDBC + Custom Pool
REST Testing -	Postman

CustomConnectionPool Logic

    Manages a fixed number of database connections using BlockingQueue

Supports:
    
    ✅ Initializing a pool with N connections
    
    ✅ Thread-safe acquisition of connection (with timeout)
    
    ✅ Releasing connection back to pool
    
    ✅ Graceful shutdown of all connections

👨‍💻 Author
Piyush Kumar
Java Backend Developer | Spring Boot | Microservices
