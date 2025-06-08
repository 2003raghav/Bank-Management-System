package swingsdemo;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class connect {
	public static void main(String[] args) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String username="system";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/banks","root","");
			System.out.println("Connected");
			}catch(Exception e1)
		{
		  System.out.println("Opps,error:");
		 e1.printStackTrace();
		 
		}
	}

	private static void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}

	}
	
	
	
