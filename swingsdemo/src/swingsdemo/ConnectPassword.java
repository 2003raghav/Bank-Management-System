package swingsdemo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class ConnectPassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtEnterNewPassword;
	private JTextField textField_1;
	private JTextField txtUserid;
	private JPasswordField Change;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnectPassword frame = new ConnectPassword();
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
	public ConnectPassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("CheckBox.darkShadow"));
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
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				details da=new details();
				da.show();
				dispose();
				
			}
		});
		btnNewButton.setBounds(0, 39, 89, 23);
		contentPane.add(btnNewButton);
		
	    JButton btnNewButton_1 = new JButton("Password");
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		btnNewButton_1.setBounds(87, 39, 89, 23);
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
		Transactions.setBounds(172, 39, 89, 23);
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
		Loan.setBounds(259, 39, 89, 23);
		contentPane.add(Loan);
		
		JButton btnNewButton_4 = new JButton("LOGOUT");
		btnNewButton_4.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		btnNewButton_4.setBounds(340, 39, 89, 23);
		contentPane.add(btnNewButton_4);
		
		txtEnterNewPassword = new JTextField();
		txtEnterNewPassword.setBackground(UIManager.getColor("Button.shadow"));
		txtEnterNewPassword.setText("Enter ID");
		txtEnterNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterNewPassword.setBounds(36, 90, 140, 20);
		contentPane.add(txtEnterNewPassword);
		txtEnterNewPassword.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Submit");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    try {
			    	Class.forName("com.mysql.jdbc.Driver");
			    	  String password = Change.getText();
					    String userid =txtUserid.getText();
					    String sql="UPDATE userdetails set password='"+password+"' where Userid='"+userid+"'";
						Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/banks","root","");

			        System.out.println("Updating password for user ID " + userid);

			        PreparedStatement st = connection.prepareStatement(sql);
			       

			        int rowsUpdated = st.executeUpdate();
			        if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(Change, "Password has been successfully changed");
                    } else {
                    	 JOptionPane.showMessageDialog(Change, "User ID not found");
                    }
			        st.close();
                    connection.close();

			    } catch (SQLException sqlException) {
			        sqlException.printStackTrace();
			        JOptionPane.showMessageDialog(Change, "Error updating password: " + sqlException.getMessage());
			} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_5.setBounds(172, 175, 89, 23);
		contentPane.add(btnNewButton_5);
		
		textField_1 = new JTextField();
		textField_1.setText("Enter New Password");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBackground(UIManager.getColor("Button.shadow"));
		textField_1.setBounds(36, 121, 140, 20);
		contentPane.add(textField_1);
		
		txtUserid = new JTextField();
		txtUserid.setText("userid");
		txtUserid.setColumns(10);
		txtUserid.setBounds(186, 90, 140, 20);
		contentPane.add(txtUserid);
		
		Change = new JPasswordField();
		Change.setBounds(186, 120, 140, 20);
		contentPane.add(Change);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deframe de=new deframe();
				de.show();
				dispose();
			}
		});
	}
}
