package swingsdemo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class details extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField detailss;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					details frame = new details();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public details() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);	
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		layeredPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(layeredPane);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new BevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.focus"), null, null, null));
		layeredPane_1.setBounds(0, 0, 429, 42);
		contentPane.add(layeredPane_1);
		
		textField = new JTextField();
		textField.setText("MVJ NATIONAL BANK");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(10, 11, 409, 20);
		layeredPane_1.add(textField);
		
		JButton btnNewButton = new JButton("DETAILS");
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		btnNewButton.setBounds(0, 42, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Password");
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectPassword co=new ConnectPassword();
				co.show();
				dispose();
			}
		});
		btnNewButton_1.setBounds(87, 42, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton Transactions = new JButton("Transactions");
		Transactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transactions t=new Transactions();
				t.show();
				dispose();
			}
		});
		Transactions.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		Transactions.setBounds(172, 42, 89, 23);
		contentPane.add(Transactions);
		
		JButton Loan = new JButton("Loan");
		Loan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loan l=new Loan();
				l.show();
				dispose();
			}
		});
		Loan.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		Loan.setBounds(259, 42, 89, 23);
		contentPane.add(Loan);
		
		JButton btnNewButton_4 = new JButton("LOGOUT");
		btnNewButton_4.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deframe de=new deframe();
				de.show();
				dispose();
			}
		});
		btnNewButton_4.setBounds(340, 42, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("Enter ID");
		lblNewLabel.setBounds(58, 112, 100, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(58, 143, 100, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnFetchDetails = new JButton("Fetch details");
		btnFetchDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
		        PreparedStatement stmt = null;
		        ResultSet rs ;
		        try {
		            
		        	Class.forName("com.mysql.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/banks","root","");

		            String userId=textField_1.getText();
		            String sql =   "SELECT * FROM userdetails WHERE Userid='"+userId+"'";  
		            stmt = connection.prepareStatement(sql);		          
		            rs = stmt.executeQuery();		          
		            StringBuffer userdetails = new StringBuffer();		          
		            while (rs.next()) {
		                String usersId = rs.getString("Userid");
		               String Name = rs.getString("Name");
		               String balance =rs.getString("Balance");
		               String age=rs.getString("Age");
		               String passwords=rs.getString("password");
		               String gender=rs.getString("Gender");
		               userdetails.append("Userid: ").append(usersId).append(", Name: ").append(Name).append(", Balance: ").append(balance).append(", Age: ").append(age).append(",Gender: ").append(gender).append("\n");
		            }
		            detailss.setText(userdetails.toString());

		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error fetching user details: " + ex.getMessage());
		        } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		btnFetchDetails.setForeground(Color.BLACK);
		btnFetchDetails.setBackground(Color.WHITE);
		btnFetchDetails.setBounds(210, 171, 120, 23);
		contentPane.add(btnFetchDetails);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(200, 106, 148, 20);
		contentPane.add(textField_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 137, 148, 20);
		contentPane.add(passwordField);
		
		detailss = new JTextField();
		detailss.setEditable(false);
		detailss.setBounds(0, 219, 429, 31);
		contentPane.add(detailss);
		detailss.setColumns(10);
	}
}
