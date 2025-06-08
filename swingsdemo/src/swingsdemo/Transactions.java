package swingsdemo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JList;

public class Transactions extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transactions frame = new Transactions();
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
	public Transactions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new BevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.focus"), null, null, null));
		contentPane.add(layeredPane);
		
		textField = new JTextField();
		textField.setText("MVJ NATIONAL BANK");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(10, 11, 409, 20);
		layeredPane.add(textField);
		
		JButton btnNewButton = new JButton("DETAILS");
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Password");
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		contentPane.add(btnNewButton_1);
		
		JButton Transactions = new JButton("Transactions");
		Transactions.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		contentPane.add(Transactions);
		
		JButton Loan = new JButton("Loan");
		Loan.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		contentPane.add(Loan);
		
		JButton btnNewButton_4 = new JButton("LOGOUT");
		btnNewButton_4.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		contentPane.add(btnNewButton_4);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new BevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.focus"), null, null, null));
		layeredPane_1.setBounds(0, 0, 447, 42);
		contentPane.add(layeredPane_1);
		
		textField_1 = new JTextField();
		textField_1.setText("MVJ NATIONAL BANK");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setBounds(28, 11, 409, 20);
		layeredPane_1.add(textField_1);
		
		JButton btnNewButton_2 = new JButton("DETAILS");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				details da=new details();
				da.show();
				dispose();
			}
		});
		btnNewButton_2.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		btnNewButton_2.setBounds(0, 42, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("Password");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectPassword co=new ConnectPassword();
				co.show();
				dispose();
			}
		});
		btnNewButton_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		btnNewButton_1_1.setBounds(87, 42, 89, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton Transactions_1 = new JButton("Transactions");			
		Transactions_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Transactions_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		Transactions_1.setBounds(176, 42, 96, 23);
		contentPane.add(Transactions_1);
		
		JButton Loan_1 = new JButton("Loan");
		Loan_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loan l=new Loan();
				l.show();
				dispose();
			}
		});
		Loan_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		Loan_1.setBounds(271, 42, 89, 23);
		contentPane.add(Loan_1);
		
		JButton btnNewButton_4_1 = new JButton("LOGOUT");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deframe de=new deframe();
				de.show();
				dispose();
			}
		});
		final JTextArea textArea = new JTextArea();
		textArea.setTabSize(5);
		textArea.setBackground(Color.GRAY);
		textArea.setBounds(0, 76, 447, 140);
		contentPane.add(textArea);
		btnNewButton_4_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		btnNewButton_4_1.setBounds(358, 42, 89, 23);
		contentPane.add(btnNewButton_4_1);
		
		JButton Fetch = new JButton("Fetch");
		Fetch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conn = null;
            try {
		            
            	Class.forName("com.mysql.jdbc.Driver");
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/banks","root","");
		            String sql =   "SELECT * FROM  Transaction" ;  
		            java.sql.PreparedStatement stmt = connection.prepareStatement(sql);		          
		            java.sql.ResultSet rs =  stmt.executeQuery();		          
		            StringBuffer userdetails = new StringBuffer();		          
		            while (rs.next()) {
		                String Transid = rs.getString("Transid");
		               String Transfer = rs.getString("Transfer");
		               String Benfid =rs.getString("Benfid");
		               String Amount=rs.getString("Amount");
		               String Da=rs.getString("Da");
		               String Tim =rs.getString("Tim");
		               userdetails.append("Transid: ").append(Transid).append(", Query: ").append(Transfer).append(", Benfid: ").append(Benfid).append(", Amount: ").append(Amount).append(",Date: ").append(Da).append(" ,Time: ").append(Tim ).append("\n");
		               
		            }
		  
		            textArea .setText(userdetails.toString());

		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error fetching user details: " + ex.getMessage());
		        } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		Fetch.setBounds(176, 227, 89, 23);
		contentPane.add(Fetch);
		
		
	}
}
