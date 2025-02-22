package com.pavan.controler;

import java.util.Scanner;

import com.pavan.dto.Student;
import com.pavan.service.IStudentService;
import com.pavan.serviceFactory.StudentServiceFactory;

public class StudentStart {
	private static int count = 100;
	private static IStudentService student;
	static Scanner sc = null;

	public static void main(String[] args) {
		boolean flag = false;
		Integer choice = null;
		
		System.out.println();
		System.out.println("Welcome to Student Managment System.");

		while (!flag) {
			Scanner uInput = new Scanner(System.in);
			System.out.println();
			System.out.println("Please Select any of the following options :");
			System.out.println("*********************************************");
			System.out.println("Please Enter 1 For Adding 	the Student Details ");
			System.out.println("Please Enter 2 For Searching 	the Student Details");
			System.out.println("Please Enter 3 For Updating  	the Student Details");
			System.out.println("Please Enter 4 For Deleting  	the Student Details");
			System.out.println("Please Enter 5 For Exit");
			choice = uInput.nextInt();
			switch (choice) {
			case 1:
				addStudent();
				break;
			case 2:
				searchStudent();
				break;
			case 3:
				updateStudent();
				break;
			case 4:
				deleteStudent();
				break;
			case 5:
				flag = true;
				break;
			default:
				System.out.println("Please choose right option");
				break;

			}
//			uInput.close();
//			choice = null;
		}

//		addStudent();
//		searchStudent();
//		updateStudent();
//		deleteStudent();

	}

	public static void deleteStudent() {
		student = StudentServiceFactory.getStudentService();
		Integer sId;

		sc = new Scanner(System.in);
		System.out.print("Enter the Student Id : ");
		sId = sc.nextInt();
		
		String result = student.deleteStudent(sId);
		System.out.println(result);

	}

	public static void updateStudent() {
		Integer sId;
		String sName;
		Integer sAge;
		String sAddress;

		student = StudentServiceFactory.getStudentService();
		Student std = null;

		sc = new Scanner(System.in);
		// taking up the id
		System.out.print("enter the StudentId : ");
		sId = sc.nextInt();
		std = student.searchStudent(sId);

		System.out.print("Do You want to Update the name " + std.getsName() + " :[Y|N] ");
		if (sc.next().equalsIgnoreCase("y")) {
			System.out.print("Enter the Name : ");
			sName = sc.next();
		} else
			sName = std.getsName();

		System.out.print("Do You want to Update the Age " + std.getsAge() + " :[Y|N] ");
		if (sc.next().equalsIgnoreCase("y")) {
			System.out.print("Enter the Age : ");
			sAge = sc.nextInt();
		} else
			sAge = std.getsAge();

		System.out.print("Do You want to Update the Address " + std.getsAddress() + " :[Y|N] ");
		if (sc.next().equalsIgnoreCase("y")) {
			System.out.print("Enter the Address : ");
			sAddress = sc.next();
		} else
			sAddress = std.getsAddress();

		student.updateStudent(sId, sName, sAge, sAddress);
	}

	public static void searchStudent() {
		sc = new Scanner(System.in);
		System.out.print("Enter the Student Id : ");
		int sId = sc.nextInt();
		student = StudentServiceFactory.getStudentService();
		Student std = student.searchStudent(sId);
		if (std != null) {
			System.out.println(std);
			System.out.println();
			System.out.println("sId\tsName\tsAge\tsAddress");
			System.out.println(std.getsId() + "\t" + std.getsName() + "\t" + std.getsAge() + "\t" + std.getsAddress());
		} else
			System.out.println("Student not found for the given id : " + sId);

	}

	public static void addStudent() {
//		int sId = generateStudentId();
		int sId = ++count;
		sc = new Scanner(System.in);
		System.out.print("Enter the name of the Student : ");
		String sName = sc.next();
		System.out.print("enter the age of the student : ");
		int sAge = sc.nextInt();
		System.out.print("Enter Student Address : ");
		String sAddress = sc.next();

		student = StudentServiceFactory.getStudentService();
		String result = student.addStudent(sId, sName, sAge, sAddress);
		System.out.println(result);
//		sc.close();
	}

	public static int generateStudentId() {
		return count+1;
	}

}
