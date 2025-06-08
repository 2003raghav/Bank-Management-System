package swingsdemo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.Font;

public class deframe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Userid;
	private JPasswordField password;
	private final JLayeredPane layeredPane = new JLayeredPane();
	private JTextField txtMvjNationalNaank;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deframe frame = new deframe();
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
	public deframe() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 216);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Userid = new JTextField();
		Userid.setBounds(182, 60, 148, 20);
		contentPane.add(Userid);
		Userid.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter ID");
		lblNewLabel.setBounds(40, 63, 100, 14);
		contentPane.add(lblNewLabel);
		
		password = new JPasswordField();
		password.setBounds(182, 91, 148, 20);
		contentPane.add(password);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(40, 94, 100, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
			
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/banks","root","");
					Statement st=connection.createStatement();
					String userid=Userid.getText();
					String pass=password.getText();
					String sql="Select * from userdetails where userid='"+userid+"'and password='"+pass+"'";
					ResultSet ra=st.executeQuery(sql);
					if(ra.next())
					{
						dispose();
						onepage one=new onepage();
						one.show();
					}else
					{
						JOptionPane.showMessageDialog(null, "Wrong id or password");
					}
				}catch(Exception e1)
				{
				  System.out.println("Opps,error:");
				 e1.printStackTrace();
				 
				}
			}
			
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(210, 122, 89, 23);
		contentPane.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(98, 11, 1, 2);
		contentPane.add(separator);
		layeredPane.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		layeredPane.setBackground(Color.LIGHT_GRAY);
		layeredPane.setBounds(0, 0, 410, 42);
		contentPane.add(layeredPane);
		
		txtMvjNationalNaank = new JTextField();
		txtMvjNationalNaank.setEditable(false);
		txtMvjNationalNaank.setBackground(Color.LIGHT_GRAY);
		txtMvjNationalNaank.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		txtMvjNationalNaank.setHorizontalAlignment(SwingConstants.CENTER);
		txtMvjNationalNaank.setText("MVJ NATIONAL BANK");
		txtMvjNationalNaank.setBounds(10, 11, 390, 20);
		layeredPane.add(txtMvjNationalNaank);
		txtMvjNationalNaank.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("If ID not found collect it from bank");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setToolTipText("");
		lblNewLabel_2.setBounds(143, 152, 214, 14);
		contentPane.add(lblNewLabel_2);
	}
}
