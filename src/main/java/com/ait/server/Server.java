package com.ait.server;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

import com.ait.entities.Student;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Server {
	private Connection con = null;
	private static Statement stmt = null;
	private PreparedStatement ps = null;

	public void initDBConnection() {
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/studentDB";
			con = DriverManager.getConnection(url, "root", "admin");
			stmt = con.createStatement();
			ps = con.prepareStatement("select * from studentDB");
		} catch (Exception e) {
			System.out.println("Failed to initialise DB Connection");
		}
	}
	
	public static String listStudents() throws SQLException {
			return stmt.executeQuery("select * from student;").toString();
	}
	public static void addStudent(final int studentId, final String name, final String subject, final double grade) throws SQLException {
		String cmd = "INSERT INTO student VALUES ('"+ studentId +"',"
				+ " '"+ name +"', '"+ subject+"', '"+ grade +"')";
		stmt.execute(cmd);
	}
	
	public static void getStudent(final int studentId) throws SQLException {
		
	}
	
	public static void removeStudent() {
		
	}
	
	public static void updateStudent() {
		
	}
}
