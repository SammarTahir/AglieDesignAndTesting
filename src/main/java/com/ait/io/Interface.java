package com.ait.io;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ait.entities.Principal;
import com.ait.entities.Student;
import com.ait.server.Server;

public class Interface {
	public static String PASSWORD = "password";
	static Scanner sc = new Scanner(System.in);
	static Server s = new Server();

	public static void main(String[] args) throws SQLException {
		// Connecting to the server
		System.out.print("Please Enter password to connect to server: ");
		String userLogin = sc.next();
		if (userLogin.equalsIgnoreCase(PASSWORD)) {
			s.initDBConnection();
			start();
		} else {
			System.out.println("Invalid Password!");
		}

	}
	
	public static void start() throws SQLException {
		int userInput = 7;
		while(userInput != 6) {
			displayMenu();
			System.out.print("Please choose a number: ");
			userInput = sc.nextInt();
			switch (userInput) {
			case 1:
				listStudents();
				break;
			case 2:
				addStudent();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;

			default:
				break;
			}
		}
		System.out.println("\nClosing application");
	}
	
	public static void displayMenu() {
		System.out.println("==== School Student Database ====");
		System.out.println("1. - List all the students");
		System.out.println("2. - Add a new student");
		System.out.println("3. - Remove a student");
		System.out.println("4. - Update student information");
		System.out.println("5. - Search for student");
		System.out.println("6. - Exit the application");
	}
	
	public static void addStudent() throws SQLException {
		System.out.print("Enter Student ID: ");
		final int studentId = sc.nextInt();
		
		System.out.print("Enter Student First Name: ");
		final String studentName = sc.next();
		
		System.out.print("Enter Student Subject: ");
		final String studentSubject = sc.next();
		
		System.out.print("Enter Student Grade: ");
		final double studentGrade = sc.nextDouble();
		
		final Principal principal = new Principal();
		principal.addStudent(studentId, studentName, studentSubject, studentGrade);
		
		System.out.println("Adding student to school.....");
		System.out.println("Student " + studentName + "has been added to the school");
	}
	
	public static void listStudents() throws SQLException {
		 System.out.println("Student enrollment list");
	        final Principal pricipal = new Principal();
	        final List<Student> students = pricipal.getStudents();
	        for (final Student student : students){
				System.out.println(student.getStudentId()+" "+ student.getName());
			}
	}
}







































