package com.ait.io;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ait.entities.Principal;
import com.ait.entities.Student;
import com.ait.server.Server;

public class Interface {
	final static String PASSWORD = "password";
	static Scanner sc = new Scanner(System.in);
	static Server s = new Server();

	public static void main(String[] args) throws SQLException {
		// Getting password from user to ensure principal
		System.out.print("Please Enter password to connect to server: ");
		String userLogin = sc.next();
		connectToServer(userLogin);
	}
	
	// This method is used for password validation
	public static Boolean connectToServer(String userLogin) throws SQLException {
		if (userLogin.equalsIgnoreCase(PASSWORD)) {
			// Connects to SQL database
			s.initDBConnection();
			// Starting the application
			start();
			return true;
		} else {
			// Only output if user enters wrong password
			System.out.println("Invalid Password!");
			return false;
		}
	
	}
	
	public static void start() throws SQLException {
		int exit = 7;
		// Simple while loop for menu options
		while(exit != 6) {
			exit = menu(7);
		}
	}
	
	// Method for main user inputs
	public static int menu(int userInput) throws SQLException {
		System.out.println("==== School Student Database ====");
		System.out.println("1. - List all the students");
		System.out.println("2. - Add a new student");
		System.out.println("3. - Remove a student");
		System.out.println("4. - Update student information");
		System.out.println("5. - Search for student");
		System.out.println("6. - Exit the application");
		System.out.print("Please choose a number: ");
		userInput = sc.nextInt();
		// Switch with different CRUD options
		switch (userInput) {
		case 1:
			listStudents();
			break;
		case 2:
			addStudent();
			break;
		case 3:
			removeStudent();
			break;
		case 4:
			updateStudent();
			break;
		case 5:
			getStudent();
			break;
		case 6:
			System.out.println("\nClosing application");
			break;
		default:
			System.out.println("Invalid input!");
			break;
		}
		return userInput;
	}
	
	// Adding student to the database
	public static void addStudent() throws SQLException {
		System.out.print("Enter Student ID: ");
		final int studentId = sc.nextInt();
		
		System.out.print("Enter Student's First Name: ");
		final String studentName = sc.next();
		
		System.out.print("Enter Student's Subject: ");
		final String studentSubject = sc.next();
		
		System.out.print("Enter Student's Grade: ");
		final double studentGrade = sc.nextDouble();
		
		final Principal principal = new Principal();
		principal.addStudent(studentId, studentName, studentSubject, studentGrade);
		
		System.out.println("Adding student to school.....");
		System.out.println("Student " + studentName + "has been added to the school");
	}
	
	// Listing all students in database
	public static void listStudents() throws SQLException {
		 System.out.println("Student enrollment list");
	     
		 final Principal pricipal = new Principal();
	     System.out.println(pricipal.getStudents());
	       
	}
	
	// Getting one student from database
	public static void getStudent() throws SQLException {
		System.out.print("Enter student ID: ");
		final int studentId = sc.nextInt();
		
		final Principal principal = new Principal();
		System.out.println(principal.getStudent(studentId));
	}

	// Removing one student from database
	public static void removeStudent() throws SQLException{
		System.out.println("Enter student ID of student to remove: ");
		final int studentId = sc.nextInt();
		
		final Principal principal = new Principal();
		principal.removeStudent(studentId);
	}
	
	public static void updateStudent() throws SQLException {
		System.out.print("Enter Student ID: ");
		final int studentId = sc.nextInt();
		
		System.out.print("Enter new Student's First Name: ");
		final String studentName = sc.next();
		
		System.out.print("Enter new Student's Subject: ");
		final String studentSubject = sc.next();
		
		System.out.print("Enter new Student's Grade: ");
		final double studentGrade = sc.nextDouble();
		
		final Principal principal = new Principal();
		principal.updateStudent(studentId, studentName, studentSubject, studentGrade);
		
	}
}







































