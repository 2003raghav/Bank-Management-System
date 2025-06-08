package swingsdemo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTree;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Loan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loan frame = new Loan();
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
	public Loan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 399);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new BevelBorder(BevelBorder.LOWERED, UIManager.getColor("Button.focus"), null, null, null));
		layeredPane.setBounds(0, 0, 429, 42);
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				details da=new details();
				da.show();
				dispose();
			}
		});
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		btnNewButton.setBounds(0, 42, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Password");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectPassword co=new ConnectPassword();
				co.show();
				dispose();
			}
		});
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
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
			}
		});
		Loan.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		Loan.setBounds(259, 42, 89, 23);
		contentPane.add(Loan);
		
		JButton btnNewButton_4 = new JButton("LOGOUT");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deframe de=new deframe();
				de.show();
				dispose();
			}
		});
		btnNewButton_4.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		btnNewButton_4.setBounds(340, 42, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_2 = new JButton("Apply");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InsertElementExample in = new InsertElementExample();
					in.show();
					
					
				}catch(Exception e1)
				{
					  System.out.println("Opps,error:");
					 e1.printStackTrace();
					 
					}
				 
			}
		});
		btnNewButton_2.setBounds(172, 176, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
