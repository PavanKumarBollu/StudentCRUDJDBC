package com.pavan.controler;

import java.util.Scanner;

import com.pavan.dto.Student;
import com.pavan.service.IStudentService;
import com.pavan.serviceFactory.StudentServiceFactory;

public class StudentStart {
	private static int count = 100;
	private static IStudentService student;
	static Scanner sc =null;
	public static void main(String[] args) {
		
//		addStudent();
		searchStudent();
		
	
	}
	public static void searchStudent()
	{
		sc = new Scanner(System.in);
		System.out.print("Enter the Student Id : ");
		int sId = sc.nextInt();
		student = StudentServiceFactory.getStudentService();
		Student std = student.searchStudent(sId);
		if(std != null) {
			System.out.println(std);
		}
		else
			System.out.println("Student not found for the given id : " + sId);
		
	}

	public static void addStudent() {
		int sId = generateStudentId();
		sc = new Scanner(System.in);
		System.out.print("Enter the name of the Student : ");
		String sName = sc.next();
		System.out.print("enter the age of the student : ");
		int sAge = sc.nextInt();
		System.out.print ("Enter Student Address : ");
		String sAddress = sc.next();
				
		student = StudentServiceFactory.getStudentService();
		String result = student.addStudent(sId, sName, sAge, sAddress);
		System.out.println(result);
		sc.close();
	}
	
	public static int generateStudentId() {
		return count++;
	}

}
