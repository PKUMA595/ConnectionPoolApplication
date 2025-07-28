🚀 ConnectionPoolApplication
A Spring Boot project demonstrating how to implement and use a Custom Connection Pool for managing database connections manually — without relying on third-party libraries like HikariCP.

✅ This project uses H2 In-Memory Database, and JDBC (not JPA) for SQL operations, enabling better understanding of manual connection handling.

📌 Project Highlights
✅ Custom Connection Pool (configurable size)
✅ Manual Connection Acquire & Release logic
✅ JDBC-based Repository layer with SQL queries
✅ In-memory H2 database (no external setup required)
✅ Clean architecture (Controller → Repository)
✅ Tested using Postman for REST API endpoints

🛠️ Tech Stack
Framework	- Spring Boot
Language - 	Java
Build Tool -	Maven
DB - 	H2 In-Memory
REST Tool -	Postman
Data Access -	JDBC + Custom Pool

CustomConnectionPool:
  Manages a pool of DB connections using a thread-safe BlockingQueue.
Handles:
  - Initializing N number of connections
  - Acquiring connection with timeout
  - Releasing connection back to pool
  - Graceful shutdown

👨‍💻 Author
Piyush Kumar
Java Backend Developer | Spring Boot | Microservices | 
📫 www.linkedin.com/in/piyushoo7
