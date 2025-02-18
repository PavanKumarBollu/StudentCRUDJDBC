package com.pavan.persistentcy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pavan.dto.Student;
import com.pavan.util.JdbcUtils;

public class StudentDaoImpl implements IStudentDao {
	private  Connection connection = null;
	private  PreparedStatement ps = null;
	private  ResultSet resultSet = null;
	
//	public static void main(String[] args) {
//		addStuden(1,"_a", 24, "HYD");
//	}
	
	
	@Override
	public String addStudent(Integer sId, String sName, Integer sAge, String sAddress) {
		String flag = null;
		try {
			connection = JdbcUtils.getConnection();
			if(connection != null)
			{
				String insertQuery = "insert into student (`sId`,`sName`,`sAge`,`sAddress`) values(?,?,?,?)";
				ps = connection.prepareStatement(insertQuery );
				if(ps != null)
				{
					ps.setInt(1, sId);
					ps.setString(2, sName);
					ps.setInt(3, sAge);
					ps.setString(4, sAddress);
					
					int count = ps.executeUpdate();
					System.out.println(count + " rows are effected");
					if(count != 0)
						flag = "Data Inserted Sucessfull ";
					else
						flag = "Failed to Insert the data ";
				}
			}
						
		} catch (SQLException | IOException e) {
			
			e.printStackTrace();
		}
		finally
		{
			try {
				JdbcUtils.closeResources(connection, null, null);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return flag ;
	}

	@Override
	public Student searchStudent(Integer sId) {
		String selectQuery = "select sId, sName, sAge, sAddress from student where sId = ?";
		Student std = null;
		try {
			connection = JdbcUtils.getConnection();
			if(connection != null)
				ps = connection.prepareStatement(selectQuery);
			if(ps != null)
			{
				ps.setInt(1, sId);
				
				resultSet = ps.executeQuery();
				if(resultSet.next()) {
					std = new Student();
					std.setsId(resultSet.getInt("sId"));
					std.setsName(resultSet.getString("sName"));
					std.setsAge(resultSet.getInt("sAge"));
					std.setsAddress(resultSet.getString("sAddress"));
					return std;
							
				}
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		return std;
	}

	@Override
	public String updateStudent(Integer sId, String sName, Integer sAge, String sAddress) {
		return null;
	}

	@Override
	public String deleteStudent(Integer sId) {
		return null;
	}

}
