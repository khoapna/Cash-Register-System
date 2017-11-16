/*
 * Project title: Cash Register System
 * Part name:     Sign In
 * Description:   Use for signing in with user and account in Database
 * Author:        
 * Last edited:   9:03 PM Nov 16, 2017
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class SignIn {

	private JFrame frame;
	private JTextField field_User;
	private JPasswordField field_Pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn window = new SignIn();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 322, 235);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogIn = new JLabel("Sign In");
		lblLogIn.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblLogIn.setEnabled(false);
		lblLogIn.setBounds(101, 11, 105, 34);
		frame.getContentPane().add(lblLogIn);
		
		JLabel user = new JLabel("User");
		user.setEnabled(false);
		user.setFont(new Font("Tahoma", Font.PLAIN, 20));
		user.setBounds(32, 44, 59, 36);
		frame.getContentPane().add(user);
		
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		password.setEnabled(false);
		password.setBounds(32, 92, 92, 34);
		frame.getContentPane().add(password);
		
		field_User = new JTextField();
		field_User.setBounds(134, 56, 141, 20);
		frame.getContentPane().add(field_User);
		field_User.setColumns(10);
		
		field_Pass = new JPasswordField();
		field_Pass.setBounds(134, 101, 141, 24);
		frame.getContentPane().add(field_Pass);
		
		JButton btnLogIn = new JButton("Sign In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkAccount();
			}
		});
		btnLogIn.setBounds(32, 151, 89, 23);
		frame.getContentPane().add(btnLogIn);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); // Click to CLOSE
			}
		});
		btnClose.setBounds(186, 151, 89, 23);
		frame.getContentPane().add(btnClose);
	}
	
	private void checkAccount() {
		String password = User.hashFunction(field_Pass.getText()); // Hash INPUT PASSWORD
		String username = field_User.getText();
		
		if(username == "" || password == "") {
			JOptionPane.showMessageDialog(null, "Invalid user/password", "Error", 2);
		}
		else {
			Connection connection;
			PreparedStatement ps;
			try {
				connection = database.dataAccess();
				ps = connection.prepareStatement("Select * from ACCOUNT where USER=? and PASSWORD=?");
				ps.setString(1, username);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				
				if (rs.next()) {
					/**
					 * Check if data in 2 text fields are same with those in DB
					 */
					JOptionPane.showMessageDialog(null, "Successful", "Message", 1);
					System.exit(0); // Turn off Sign In frame
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid user/password", "Error", 1);
					/** 
					 * Erase data in 2 text fields
					 */
					field_User.setText("");
					field_Pass.setText("");
					field_User.requestFocus();
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}
}
