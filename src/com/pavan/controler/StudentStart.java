package com.pavan.controler;

import com.pavan.service.IStudentService;
import com.pavan.serviceFactory.StudentServiceFactory;

public class StudentStart {

	public static void main(String[] args) {
		IStudentService student = StudentServiceFactory.getStudentService();
		
		
	
	}

}
