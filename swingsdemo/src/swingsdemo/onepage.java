package swingsdemo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;

public class onepage extends JFrame {

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
					onepage frame = new onepage();
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
	public onepage() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 374);
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\rkahy\\OneDrive\\Pictures\\MVJCE-BE-admission-2024-featured-image.jpg"));
		lblNewLabel.setBounds(0, 108, 429, 227);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("                    Welcome to MVJ National Bank");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 77, 409, 23);
		contentPane.add(lblNewLabel_1);
	}
}
