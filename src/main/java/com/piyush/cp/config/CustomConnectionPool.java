package com.piyush.cp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomConnectionPool {
	
	private final LinkedBlockingQueue<Connection> pool;
	private final String jdbcUrl;
	private final String username;
	private final String password;
	
	public CustomConnectionPool(String jdbcUrl, String username, String password, int poolSize) throws SQLException{
		
		this.jdbcUrl = jdbcUrl;
		this.username = username;
		this.password = password;
		this.pool = new LinkedBlockingQueue<>(poolSize);
		
		initializePool(poolSize);
		
	}
	
	// initializing all connections and saving it in a Concurrent Queue to use
	private void initializePool(int poolSize) throws SQLException {
		for(int i =0; i<poolSize; i++) {
			Connection connection = createConnection();
			pool.offer(connection);
		}
	}
	
	// create connection and save in pool
	private Connection createConnection() throws SQLException {
		return DriverManager.getConnection(jdbcUrl, username, password);
	}
	
	public Connection getConnection() throws InterruptedException{
		return pool.take(); // waits if no connection available
	}
	
	public void releaseConnection(Connection connection) {
		if(connection != null) {
			pool.offer(connection);
		}
	}
	
	public void closeAllConnections() throws SQLException{
		for(Connection connection :pool) {
			connection.close();
		}
	}
	
	
	

}
