package ex_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ex_model.User;

//this dao class provides crud database operations to users of the db

public class UserDao {

	private String jdbcLink = "jdbc:mysql://localhost:3306/ex_project";
	private String jdbcUN = "root";
	private String jdbcPW = "root";
	
	private static final String INSERT_USER_SQL = "INSERT INTO users (Name, Country) VALUES (?,?);";
	private static final String SELECT_USER_BY_ID = "SELECT ID, Name, Country FROM users WHERE id = ?";
	private static final String SELECT_ALL_USERS = "SELECT * FROM users";
	private static final String DELETE_USER_SQL = "DELETE FROM users WHERE id = ?;";
	private static final String UPDATE_USER_SQL = "UPDATE users set name = ?, country = ? WHERE id = ?;";
	
	
	protected Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcLink, jdbcUN, jdbcPW);
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public void insertUser(User user) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(INSERT_USER_SQL);
			ps.setString(1, user.getName());
			ps.setString(2, user.getCountry());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public boolean updateUser(User user) {
		boolean rowUpdated = false;
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(UPDATE_USER_SQL);
			ps.setString(1, user.getName());
			ps.setString(2, user.getCountry());
			ps.setInt(3, user.getId());
			
			rowUpdated = ps.executeUpdate() > 0 ;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}
	
	public User selectUser(int id) {
		User user  = null;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(SELECT_USER_BY_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("Name");
				String country = rs.getString("Country");
				user = new User(id, name, country);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public ArrayList<User> selectAllUsers() {
		ArrayList<User> users = new ArrayList<>();
		User user  = null;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(SELECT_ALL_USERS);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("Name");
				String country = rs.getString("Country");
				user = new User(id, name, country);
				users.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public boolean deleteUser(int id) {
		boolean rowDeleted = false;
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(DELETE_USER_SQL);
			ps.setInt(1, id);
			rowDeleted = ps.executeUpdate() > 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}
}
