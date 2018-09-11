package codepack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import test.User;
import test.UserList;

public class Team9GUI implements ActionListener {
	public JFrame signUpFrame, loginFrame, accountFrame;
	public JButton loginButton, loginLink, signUpButton, signUpLink, editButton;
	JTextField userSignUp, emailSignUp, userLogIn;
	JPasswordField passwordSignUp, passwordLogIn;
	JLabel message;
	User user = new User(null, null, null);
	UserList list = new UserList();
	// JPanel messagePanel;

	public static void main(String[] args) {
		Team9GUI GUI = new Team9GUI();
	}

	private Team9GUI() {
		signUpFrame = new JFrame("SIGN UP");
		signUpFrame.setMinimumSize(new Dimension(500, 500));
		signUpFrame.setResizable(false);
		signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signUpPanel();
		signUpFrame.pack();
		signUpFrame.setLocationRelativeTo(null);
		signUpFrame.setVisible(true);
		signUpFrame.getRootPane().setDefaultButton(signUpButton);
		
		loginFrame = new JFrame("LOG IN");
		loginFrame.setMinimumSize(new Dimension(500, 500));
		loginFrame.setResizable(false);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setLocationRelativeTo(null);
		loginPanel();
		loginFrame.pack();
		loginFrame.setVisible(false);
		loginFrame.getRootPane().setDefaultButton(loginButton);
		
		accountFrame = new JFrame("ACCOUNT INFORMATION");
		accountFrame.setMinimumSize(new Dimension(500, 500));
		accountFrame.setResizable(false);
		accountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		accountFrame.setLocationRelativeTo(null);
		accountPanel();
		accountFrame.pack();
		accountFrame.setVisible(false);
		accountFrame.getRootPane().setDefaultButton(editButton);
	}

	private void loginPanel() {
		JPanel login = new JPanel();
		login.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		login.setLayout(new GridLayout(0, 1));
		JLabel loginTitle = new JLabel("LOG IN", SwingConstants.CENTER);
		loginTitle.setFont(loginTitle.getFont().deriveFont(24.0f));
		JLabel userL = new JLabel("Username");
		userLogIn = new JTextField(15);
		JLabel passL = new JLabel("Password");
		passwordLogIn = new JPasswordField(15);
		loginButton = new JButton("Log In");
		loginButton.setFont(loginButton.getFont().deriveFont(18.0f));
		loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginButton.addActionListener(this);
		JLabel signUpOption = new JLabel("Don't have an account? ", SwingConstants.CENTER);
		signUpLink = new JButton("Sign Up Here");
		signUpLink.setForeground(Color.BLUE);
		signUpLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signUpLink.setBorderPainted(false);
		signUpLink.setFocusPainted(false);
		signUpLink.setContentAreaFilled(false);
		signUpLink.addActionListener(this);
		login.add(loginTitle);
		login.add(userL);
		login.add(userLogIn);
		login.add(passL);
		login.add(passwordLogIn);
		login.add(Box.createRigidArea(new Dimension(2, 0)));
		login.add(loginButton);
		login.add(Box.createRigidArea(new Dimension(2, 0)));
		login.add(signUpOption);
		login.add(signUpLink);
		loginFrame.getContentPane().add(BorderLayout.NORTH, login);
	}

	private void signUpPanel() {
		JPanel signUp = new JPanel();
		signUp.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		signUp.setLayout(new GridLayout(0, 1));
		JLabel signUpTitle = new JLabel("SIGN UP", SwingConstants.CENTER);
		signUpTitle.setFont(signUpTitle.getFont().deriveFont(24.0f));
		JLabel userSL = new JLabel("Username");
		userSignUp = new JTextField(15);
		JLabel emailSL = new JLabel("Email");
		emailSignUp = new JTextField(15);
		JLabel passwordSL = new JLabel("Password");
		passwordSignUp = new JPasswordField(15);
		signUpButton = new JButton("Sign Up");
		signUpButton.setFont(signUpButton.getFont().deriveFont(18.0f));
		signUpButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signUpButton.addActionListener(this);
		JLabel loginOption = new JLabel("Already have an account? ", SwingConstants.CENTER);
		loginLink = new JButton("Log In Here");
		loginLink.setForeground(Color.BLUE);
		loginLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginLink.setBorderPainted(false);
		loginLink.setFocusPainted(false);
		loginLink.setContentAreaFilled(false);
		loginLink.addActionListener(this);
		signUp.add(signUpTitle);
		signUp.add(userSL);
		signUp.add(userSignUp);
		signUp.add(emailSL);
		signUp.add(emailSignUp);
		signUp.add(passwordSL);
		signUp.add(passwordSignUp);
		signUp.add(Box.createRigidArea(new Dimension(2, 0)));
		signUp.add(signUpButton);
		signUp.add(Box.createRigidArea(new Dimension(2, 0)));
		signUp.add(loginOption);
		signUp.add(loginLink);
		signUpFrame.getContentPane().add(BorderLayout.CENTER, signUp);
	}

	private void accountPanel() {
		JPanel account = new JPanel();
		account.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		account.setLayout(new GridLayout(0, 1));
		JLabel accountTitle = new JLabel("ACCOUNT INFORMATION", SwingConstants.CENTER);
		accountTitle.setFont(accountTitle.getFont().deriveFont(24.0f));
		JLabel username = new JLabel("Username: " + user.getUsername());
		JLabel email = new JLabel("Email: " + user.getEmail());
		editButton = new JButton("Edit Account");
		editButton.setFont(signUpButton.getFont().deriveFont(18.0f));
		editButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editButton.addActionListener(this);
		account.add(accountTitle);
		account.add(username);
		account.add(email);
		account.add(Box.createRigidArea(new Dimension(2, 0)));
		account.add(editButton);
		account.add(Box.createRigidArea(new Dimension(2, 0)));
		accountFrame.getContentPane().add(BorderLayout.CENTER, account);
	}	
	
	// private void messagePanel() {
	// messagePanel = new JPanel();
	// message= new JLabel("");
	// messagePanel.add(message);
	// frame.getContentPane().add(BorderLayout.SOUTH,messagePanel);
	// }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(loginButton)) {
			User check = list.findUser(userLogIn.getText(), new String(passwordLogIn.getPassword()));
			if (userLogIn.getText().equals("") || passwordLogIn.getPassword().length == 0) {
				JOptionPane.showMessageDialog(loginFrame, "Please fill in all fields.");
			} else if (check == null) {
				JOptionPane.showMessageDialog(loginFrame, "The username and password do not match.");
			} else {
				user = check;
				JOptionPane.showMessageDialog(loginFrame, "You have logged in!");
				loginFrame.setVisible(false);
				accountFrame.setVisible(true);
			}
		}

		if (e.getSource().equals(signUpButton)) {
			if (userSignUp.getText().equals("") || emailSignUp.getText().equals("")
					|| passwordSignUp.getPassword().length == 0) {
				JOptionPane.showMessageDialog(signUpFrame, "Please fill in all fields.");
			} else if (!user.checkEmail(emailSignUp.getText())) {
				JOptionPane.showMessageDialog(signUpFrame, "The email address provided was not valid.");
			} else if (list.doesEmailExist(emailSignUp.getText())) {
				JOptionPane.showMessageDialog(signUpFrame, "This email address already exists in our system.");
			} else if (list.doesUserNameExist(userSignUp.getText())) {
				JOptionPane.showMessageDialog(signUpFrame, "This username already exists in our system.");
			} else if (!user.checkPasswd(new String(passwordSignUp.getPassword()))) {
				JOptionPane.showMessageDialog(signUpFrame,
						"Your password must have at least 8 characters containing at least an uppercase letter, a lowercase letter, and a number.");
			} else {
				list.addUser(userSignUp.getText(), (new String(passwordSignUp.getPassword())), emailSignUp.getText());
				JOptionPane.showMessageDialog(signUpFrame, "Your account has been created!");
				signUpFrame.getContentPane().removeAll();
				signUpFrame.repaint();
				signUpFrame.setVisible(false);
				loginFrame.setVisible(true);
			}
		}
		if (e.getSource().equals(loginLink)) {
			signUpFrame.setVisible(false);
			loginFrame.setVisible(true);
		}		
		if (e.getSource().equals(signUpLink)) {
			loginFrame.setVisible(false);
			signUpFrame.setVisible(true);
		}
	}
}