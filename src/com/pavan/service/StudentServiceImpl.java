package com.pavan.service;

import com.pavan.daoFactory.StudentDaoFactory;
import com.pavan.dto.Student;
import com.pavan.persistentcy.IStudentDao;

public class StudentServiceImpl implements IStudentService {
//	public static void main(String[] args) {
//		String r = new StudentServiceImpl().addStudent(2, "a", 24, "d");
//		System.out.println(r);
//	}
//	
	
	IStudentDao stdDao = null;

	@Override
	public String addStudent(Integer sId, String sName, Integer sAge, String sAddress) {
		stdDao = StudentDaoFactory.getStudentDao();
		String result = stdDao.addStudent(sId, sName, sAge, sAddress);
		return result;
	}

	@Override
	public Student searchStudent(Integer sId) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.searchStudent(sId);
	
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
