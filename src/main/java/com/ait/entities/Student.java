package com.ait.entities;

public class Student {
	private final int studentId;
	private final String name;
	private final String subject;
	private final double grade;
	
	public Student(final int studentId, final String name, final String subject, final double grade) {
		this.studentId = studentId;
		this.name = name;
		this.subject = subject;
		this.grade = grade;
	}

	public int getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public String getSubject() {
		return subject;
	}

	public double getGrade() {
		return grade;
	}
	
	
}
