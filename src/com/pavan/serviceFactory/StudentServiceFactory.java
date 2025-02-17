package com.pavan.serviceFactory;


import com.pavan.service.IStudentService;
import com.pavan.service.StudentServiceImpl;

public class StudentServiceFactory {
	private StudentServiceFactory() {
		// to prevent the object Creation
	}
	public static IStudentService studentService = null;
	
	public static IStudentService getStudentService()
	{
		if(studentService == null)
			studentService = new StudentServiceImpl();
		return studentService;
	}
}
