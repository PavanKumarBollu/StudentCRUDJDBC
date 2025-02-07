package com.pavan.persistentcy;

import com.pavan.dto.Student;

public interface IStudentDao {
	
	public String addStudent(Integer sId, String sName, Integer sAge, String sAddress);
	
	public Student searchStudent(Integer sId);
	
	public String updateStudent(Integer sId, String sName, Integer sAge, String sAddress);
	
	public String deleteStudent(Integer sId);

}
