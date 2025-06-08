package swingsdemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertElementExample extends JFrame {
    private JTextField nameField, accoField, amountField, panField, incomeField, emailField, typeField;
    private JButton insertButton;

    public InsertElementExample() {
        setTitle("Insert Element Example");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create UI components
        nameField = new JTextField(20);
        accoField = new JTextField(20);
        amountField = new JTextField(20);
        panField = new JTextField(20);
        incomeField = new JTextField(20);
        emailField = new JTextField(20);
        typeField = new JTextField(20);
        insertButton = new JButton("Insert");

        // Set layout and add components
        setLayout(new GridLayout(8, 2));
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Acco:"));
        add(accoField);
        add(new JLabel("Amount:"));
        add(amountField);
        add(new JLabel("Pan:"));
        add(panField);
        add(new JLabel("Income:"));
        add(incomeField);
        add(new JLabel("Email:"));
        add(emailField);
        add(new JLabel("Type:"));
        add(typeField);
        add(insertButton);

        // Add action listener to the button
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String acco = accoField.getText();
                double amount = Double.parseDouble(amountField.getText());
                String pan = panField.getText();
                double income = Double.parseDouble(incomeField.getText());
                String email = emailField.getText();
                String type = typeField.getText();
                try {
					insertDataIntoDatabase(name, acco, amount, pan, income, email, type);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
    }

    private void insertDataIntoDatabase(String name, String acco, double amount, String pan, double income, String email, String type) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/banks";
        String user = "root";
        String password = ""; // Set your MySQL password here
    	Class.forName("com.mysql.jdbc.Driver");

        String sql = "INSERT INTO loan (Name, Acco, Amount, Pan, Income, Emailid, Type) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	
            pstmt.setString(1, name);
            pstmt.setString(2, acco);
            pstmt.setDouble(3, amount);
            pstmt.setString(4, pan);
            pstmt.setDouble(5, income);
            pstmt.setString(6, email);
            pstmt.setString(7, type);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data inserted successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error inserting data into database.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InsertElementExample().setVisible(true);
            }
        });
    }
}


	
