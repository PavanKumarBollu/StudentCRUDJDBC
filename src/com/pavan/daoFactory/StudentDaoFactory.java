package com.pavan.daoFactory;

import com.pavan.persistentcy.IStudentDao;
import com.pavan.persistentcy.StudentDaoImpl;

public class StudentDaoFactory {
	// private constructor for preventing the object
	private StudentDaoFactory() {

	}

	public static IStudentDao studentDao = null;

	public static IStudentDao getStudentDao() {
		if (studentDao == null)
			studentDao = new StudentDaoImpl();

		return studentDao;
	}

}
