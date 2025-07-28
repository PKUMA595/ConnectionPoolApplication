package com.piyush.cp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.piyush.cp.config.CustomConnectionPool;
import com.piyush.cp.model.Student;

import jakarta.annotation.PostConstruct;

@Repository
public class StudentRepository {
	
	private CustomConnectionPool connectionPool;
	
	@PostConstruct
	public void init() {
		try {
			connectionPool = new CustomConnectionPool("jdbc:h2:mem:testdb", "sa", "", 5);
			
			// create table at the start up
			try(Connection connection = connectionPool.getConnection()) {
				Statement stmt = connection.createStatement();
				stmt.executeUpdate("CREATE TABLE IF NOT EXISTS student (id INT PRIMARY KEY, name VARCHAR(225), department VARCHAR(225))");
				connectionPool.releaseConnection(connection);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void saveStudent(Student student) throws Exception{
		Connection connection = connectionPool.getConnection();
		String sql = "INSERT INTO student (id, name, department) VALUES (?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, student.getId());
		ps.setString(2, student.getName());
		ps.setString(3, student.getDepartment());
		ps.executeUpdate();
		connectionPool.releaseConnection(connection);
	}
	
	public List<Student> findAll() throws InterruptedException, SQLException{
		Connection connection = connectionPool.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM student");
		
		List<Student> students = new ArrayList<>();
		while(rs.next()) {
			students.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("department")));
		}
		connectionPool.releaseConnection(connection);
		return students;
	}

}
