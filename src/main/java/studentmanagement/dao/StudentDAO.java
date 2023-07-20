package studentmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import studentmanagement.model.Student;

public class StudentDAO {
	
	String jdbcURL = "jdbc:mysql://localhost:3306/school";
	String username = "root";
	String password = "demodemo!";
	
	String insertQuery = "Insert Into Student Values ( ?,?,?,?)";
	String deleteQuery = "Delete From Student Where Roll = ?";
	String selectQuery = "select * From Student Where Roll = ?";
	String updateQuery = "Update Student Set name=?,address=?,marks=? where roll=?";
	
	public Connection getConnection()throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(jdbcURL,username,password);
		return con;
	}
	public void update ( Student s)
	{
		try ( Connection con = getConnection();)
		{
			PreparedStatement ps = con.prepareStatement(updateQuery);
		
			ps.setString(1, s.getName());
			ps.setString(2, s.getAddress());
			ps.setDouble(3, s.getMarks());
			ps.setInt(4, s.getRoll());
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void insert ( Student s)
	{
		try ( Connection con = getConnection();)
		{
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setInt(1, s.getRoll());
			ps.setString(2, s.getName());
			ps.setString(3, s.getAddress());
			ps.setDouble(4, s.getMarks());
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<Student> getAllStudents()
	{
		List<Student> list = new ArrayList();
		
		try ( Connection con = getConnection();)
		{
			PreparedStatement ps = con.prepareStatement("Select * From Student");
			ResultSet rs = ps.executeQuery();
			while ( rs.next())
			{
				int roll = rs.getInt("roll");
				String name = rs.getString("name");
				String address = rs.getString("Address");
				double marks = rs.getDouble("marks");
				Student s = new Student(roll,name,address,marks);
				list.add(s);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	public void delete ( int roll)
	{
		try(Connection con = getConnection())
		{
			PreparedStatement ps = con.prepareStatement(deleteQuery);
			ps.setInt(1, roll);
			ps.executeUpdate();
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public Student getStudent (int roll)
	{
		Student s = null;
		try(Connection con = getConnection())
		{
			PreparedStatement ps = con.prepareStatement(selectQuery);
			ps.setInt(1, roll);
			ResultSet rs = ps.executeQuery();
			rs.next();
		
			String name = rs.getString("name");
			String address = rs.getString("Address");
			double marks = rs.getDouble("marks");
			s = new Student(roll,name,address,marks);
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return s;
	}
}
