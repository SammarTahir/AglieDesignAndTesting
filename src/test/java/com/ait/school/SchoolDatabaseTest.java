package com.ait.school;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.configuration.injection.scanner.MockScanner;
import org.mockito.internal.verification.Times;

import com.ait.boundaries.*;
import com.ait.entities.*;
import com.ait.io.*;
import com.ait.server.*;

public class SchoolDatabaseTest {
	private final StudentDAO studentDAO = mock(StudentDAO.class);
	private final Server server = mock(Server.class);
	private final Interface userInterface = mock(Interface.class);
	private Principal principal;
	private String password;

	@BeforeEach
	public void setUp() throws SQLException {
		password = null;
	}
	
	@Test
	void testConnectDatabaseSucessful() throws SQLException{
		password = "password";
		when(userInterface.menu(anyInt())).thenReturn(3);
		assertEquals(userInterface.connectToServer(password), true);
	
		
		
	}
	
	@Test
	void testConnectDatabaseUnsucesful() throws SQLException{
		password = "";
		assertEquals(userInterface.connectToServer(password), false);
		
	}
}
