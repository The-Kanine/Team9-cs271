import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * The Team9GUI class creates and manages the the visual components of the user
 * account system created for CS-HU 271.
 * 
 * @author Kalli Plumer, Keaton Gillihan
 */
public class Team9GUI implements ActionListener {
	public JFrame signUpFrame, loginFrame, accountFrame, passwordFrame, usernameFrame;
	public JButton loginButton, loginLink, signUpButton, changePasswordButton, signUpLink, exitUsernameLink, editButton,
			logoutLink, exitPasswordLink, forgotPasswordLink, retrieveUsernameButton, forgotUsernameLink;
	JTextField userSignUp, emailSignUp, userLogIn, usernameEdit, emailEdit, giveEmail, answerEdit, emailPassword,
			answerPassword;
	JPasswordField passwordSignUp, passwordLogIn, passwordEdit, passwordPassword;
	JLabel message;
	User user = new User(null, null, null);
	UserList list = new UserList();

	/**
	 * The main method that starts the Team9GUI program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Team9GUI GUI = new Team9GUI();
	}

	/**
	 * The constructor for the Team9GUI
	 */
	public Team9GUI() {
		JPanel signUpPanel = signUpPanel();
		signUpFrame = setupFrame("SIGN UP", signUpPanel, true, signUpButton);
	}

	public void quit() {

	}

	/**
	 * this method creates a login panel that contains everything that an
	 * existing user would need to login(a username field, a password field, and
	 * a login button).
	 * 
	 * @return
	 */
	private JPanel loginPanel() {
		// Create Components for loginPanel
		JPanel login = setupPanel("LOG IN");
		JLabel userL = new JLabel("Username");
		userLogIn = new JTextField(15);
		JLabel passL = new JLabel("Password");
		passwordLogIn = new JPasswordField(15);
		loginButton = createButton("Log In");
		JLabel signUpOption = new JLabel("Don't have an account? ", SwingConstants.CENTER);
		signUpLink = createLink("Sign Up Here");
		forgotPasswordLink = createLink("Forgot Password");
		forgotUsernameLink = createLink("Forgot Username");
		// add Components to loginPanel
		login.add(userL);
		login.add(userLogIn);
		login.add(passL);
		login.add(passwordLogIn);
		login.add(Box.createRigidArea(new Dimension(2, 0)));
		login.add(loginButton);
		login.add(Box.createRigidArea(new Dimension(2, 0)));
		login.add(signUpOption);
		login.add(signUpLink);
		login.add(forgotPasswordLink);
		login.add(forgotUsernameLink);
		return login;
	}

	/**
	 * this method creates a sign panel that contains everything that an new
	 * user would need to sign up(a username field, a password field, an email
	 * field, and a login button).
	 * 
	 * @return
	 */
	private JPanel signUpPanel() {
		// Create components for signUpPanel
		JPanel signUp = setupPanel("SIGN UP");
		JLabel userSL = new JLabel("Username");
		userSignUp = new JTextField(15);
		JLabel emailSL = new JLabel("Email");
		emailSignUp = new JTextField(15);
		JLabel passwordSL = new JLabel("Password");
		passwordSignUp = new JPasswordField(15);
		signUpButton = createButton("Sign Up");
		JLabel loginOption = new JLabel("Already have an account? ", SwingConstants.CENTER);
		loginLink = createLink("Log In Here");
		// add components to signUpPanel
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
		return signUp;
	}

	/**
	 * This method creates a panel that displays and lets you edit the users
	 * information
	 * 
	 * @return
	 */
	private JPanel accountPanel() {
		// create components for accountPanel
		JPanel account = setupPanel("ACCOUNT INFORMATION");
		JLabel username = new JLabel("Username: " + user.getUsername());

		usernameEdit = new JTextField(user.getUsername(), 15);
		usernameEdit.setEditable(false);
		JLabel email = new JLabel("Email: " + user.getEmail());
		emailEdit = new JTextField(user.getEmail(), 15);
		emailEdit.setEditable(false);
		JLabel password = new JLabel("Password: ");
		passwordEdit = new JPasswordField(user.getPassword(), 15);
		passwordEdit.setEditable(false);
		JLabel question = new JLabel("What is your favorite color?");
		answerEdit = new JTextField(user.getAnswer(), 15);
		answerEdit.setEditable(false);

		editButton = createButton("Edit Account");
		logoutLink = createLink("Logout");
		// add components to accountPanel
		account.add(username);
		account.add(usernameEdit);
		account.add(email);
		account.add(emailEdit);
		account.add(password);
		account.add(passwordEdit);
		account.add(question);
		account.add(answerEdit);
		account.add(Box.createRigidArea(new Dimension(2, 0)));
		account.add(editButton);
		account.add(logoutLink);
		account.add(Box.createRigidArea(new Dimension(2, 0)));
		return account;
	}

	/**
	 * This method creates a panel that lets a user change their password
	 * 
	 * @return
	 */
	private JPanel passwordPanel() {
		JPanel password = setupPanel("RESET PASSWORD");
		JLabel email = new JLabel("Email:");
		emailPassword = new JTextField(15);
		JLabel question = new JLabel("What is your Favorite Color?");
		answerPassword = new JTextField(15);
		JLabel newPassword = new JLabel("New Password:");
		passwordPassword = new JPasswordField(15);
		changePasswordButton = createButton("Reset Password");
		exitPasswordLink = createLink("Log In");

		password.add(email);
		password.add(emailPassword);
		password.add(question);
		password.add(answerPassword);
		password.add(newPassword);
		password.add(passwordPassword);
		password.add(Box.createRigidArea(new Dimension(2, 0)));
		password.add(changePasswordButton);
		password.add(exitPasswordLink);
		return password;
	}

	/**
	 * This method creates a panel that lets a user retrieve their password
	 * 
	 * @return
	 */
	private JPanel usernamePanel() {
		JPanel username = setupPanel("RETRIEVE USERNAME");
		JLabel email = new JLabel("Email:");
		giveEmail = new JTextField(15);
		retrieveUsernameButton = createButton("Confirm Email");
		exitUsernameLink = createLink("Cancel");

		username.add(email);
		username.add(giveEmail);
		username.add(Box.createRigidArea(new Dimension(2, 0)));
		username.add(retrieveUsernameButton);
		username.add(exitUsernameLink);
		return username;
	}

	/**
	 * This method is used to create a button that looks like a link
	 * 
	 * @param text
	 * @return
	 */
	private JButton createLink(String text) {
		JButton link = new JButton(text);
		link.setForeground(Color.BLUE);
		link.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		link.setBorderPainted(false);
		link.setFocusPainted(false);
		link.setContentAreaFilled(false);
		link.addActionListener(this);
		return link;
	}

	/**
	 * This method is used to create a button that looks like a button
	 * 
	 * @param text
	 * @return
	 */
	private JButton createButton(String text) {
		JButton button = new JButton(text);
		button.setFont(button.getFont().deriveFont(18.0f));
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(this);
		return button;
	}

	/**
	 * This method is used to create a frame with the appropriate specifications
	 * for this program
	 * 
	 * @param text,
	 *            panel, visible, button
	 * @return
	 */
	private JFrame setupFrame(String text, JPanel panel, boolean visible, JButton button) {
		JFrame frame = new JFrame(text);
		// frame.setMinimumSize(new Dimension(500, 500));
		frame.setMinimumSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width / 3,
				Toolkit.getDefaultToolkit().getScreenSize().height / 3));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(panel);
		frame.setVisible(visible);
		frame.pack();

		frame.getRootPane().setDefaultButton(button);
		return frame;
	}

	/**
	 * This method is used to setup the panel so that it is ready for content to
	 * be added
	 * 
	 * @param text
	 * @return
	 */
	private JPanel setupPanel(String text) {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		panel.setLayout(new GridLayout(0, 1));
		JLabel title = new JLabel(text, SwingConstants.CENTER);
		title.setFont(title.getFont().deriveFont(24.0f));
		panel.add(title);
		return panel;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// the login button on the login page is clicked
		if (e.getSource().equals(loginButton)) {
			User check = list.findUser(userLogIn.getText(), new String(passwordLogIn.getPassword()));
			// any required fields are left empty
			if (userLogIn.getText().equals("") || passwordLogIn.getPassword().length == 0) {
				JOptionPane.showMessageDialog(loginFrame, "Please fill in all fields.");
			}
			// the login information is invalid
			else if (check == null) {
				JOptionPane.showMessageDialog(loginFrame, "The username and password do not match.");
			}
			// the login information is valid
			else {
				user = check;
				JOptionPane.showMessageDialog(loginFrame, "You have logged in!");
				loginFrame.dispose();
				JPanel accountPanel = accountPanel();
				accountFrame = setupFrame("ACCOUNT INFORMATION", accountPanel, true, editButton);
			}
		}
		if (e.getSource().equals(forgotPasswordLink)) {
			loginFrame.dispose();
			JPanel passwordPanel = passwordPanel();
			passwordFrame = setupFrame("FORGOT PASSWORD", passwordPanel, true, changePasswordButton);
		}

		if (e.getSource().equals(forgotUsernameLink)) {
			loginFrame.dispose();
			JPanel usernamePanel = usernamePanel();
			usernameFrame = setupFrame("FORGOT USERNAME", usernamePanel, true, changePasswordButton);
		}

		// the sign up button on the sign up page is clicked
		if (e.getSource().equals(signUpButton)) {
			// any required fields are left empty
			if (userSignUp.getText().equals("") || emailSignUp.getText().equals("")
					|| passwordSignUp.getPassword().length == 0) {
				JOptionPane.showMessageDialog(signUpFrame, "Please fill in all fields.");
			}
			// invalid email address
			else if (!user.checkEmail(emailSignUp.getText())) {
				JOptionPane.showMessageDialog(signUpFrame, "The email address provided was not valid.");
			}
			// used email address
			else if (list.doesEmailExist(emailSignUp.getText())) {
				JOptionPane.showMessageDialog(signUpFrame, "This email address already exists in our system.");
			}
			// used username
			else if (list.doesUserNameExist(userSignUp.getText())) {
				JOptionPane.showMessageDialog(signUpFrame, "This username already exists in our system.");
			}
			// invalid password
			else if (!user.checkPasswd(new String(passwordSignUp.getPassword()))) {
				JOptionPane.showMessageDialog(signUpFrame,
						"Your password must have at least 8 characters containing at least an uppercase letter, a lowercase letter, and a number.");
			}
			// Sign up information is valid
			else {
				list.addUser(userSignUp.getText(), (new String(passwordSignUp.getPassword())), emailSignUp.getText());
				JOptionPane.showMessageDialog(signUpFrame, "Your account has been created!");
				signUpFrame.dispose();
				JPanel loginPanel = loginPanel();
				loginFrame = setupFrame("LOG IN", loginPanel, true, loginButton);
			}
		}
		// the Log In Here link on the sign up page is clicked
		if (e.getSource().equals(loginLink)) {
			signUpFrame.dispose();
			JPanel loginPanel = loginPanel();
			loginFrame = setupFrame("LOG IN", loginPanel, true, loginButton);
		}
		// the Sign Up Here link on the log in page is clicked
		if (e.getSource().equals(signUpLink)) {
			loginFrame.dispose();
			JPanel signUpPanel = signUpPanel();
			signUpFrame = setupFrame("SIGN UP", signUpPanel, true, loginButton);
		}
		if (e.getSource().equals(editButton)) {
			if (editButton.getText().equals("Edit Account")) {
				usernameEdit.setEditable(true);
				emailEdit.setEditable(true);
				passwordEdit.setEditable(true);
				answerEdit.setEditable(true);
				editButton.setText("Save Information");
			} else if (usernameEdit.getText().equals("") || emailEdit.getText().equals("")
					|| passwordEdit.getPassword().length == 0 || answerEdit.getText().equals("")) {
				JOptionPane.showMessageDialog(accountFrame, "Please fill in all fields.");
			} else // invalid email address
			if (!user.checkEmail(emailSignUp.getText())) {
				JOptionPane.showMessageDialog(accountFrame, "The email address provided was not valid.");
			}
			// used email address
			else if (list.doesEmailExist(emailSignUp.getText()) && !emailSignUp.getText().equals(user.getEmail())) {
				JOptionPane.showMessageDialog(accountFrame, "This email address already exists in our system.");
			}
			// used username
			else if (list.doesUserNameExist(userSignUp.getText()) && !userSignUp.getText().equals(user.getUsername())) {
				JOptionPane.showMessageDialog(accountFrame, "This username already exists in our system.");
			} else

			if (!user.checkPasswd(new String(passwordEdit.getPassword()))) {
				JOptionPane.showMessageDialog(accountFrame,
						"Your password must have at least 8 characters containing at least an uppercase letter, a lowercase letter, and a number.");
			} else {
				user.setUserName(usernameEdit.getText());
				user.setPasswd(new String(passwordEdit.getPassword()));
				user.setEmail(emailEdit.getText());
				user.setAnswer(answerEdit.getText());
				JOptionPane.showMessageDialog(accountFrame, "Your account has been updated!");
				accountFrame.dispose();
				JPanel accountPanel = accountPanel();
				accountFrame = setupFrame("ACCOUNT INFORMATION", accountPanel, true, editButton);
			}
		}
		// the change password button on reset password page is clicked
		if (e.getSource().equals(changePasswordButton)) {

			if (emailPassword.getText().equals("") || answerPassword.getText().equals("")
					|| passwordPassword.getPassword().length == 0) {
				JOptionPane.showMessageDialog(passwordFrame, "Please fill in all fields.");
			} else if (!list.doesEmailExist(emailPassword.getText())) {
				JOptionPane.showMessageDialog(passwordFrame, "That email address is not in our System");
			} else

			if (list.findUser2(emailPassword.getText(), answerPassword.getText()) == null) {
				JOptionPane.showMessageDialog(passwordFrame, "The security question answer is incorrect");
			} else if (!user.checkPasswd(new String(passwordPassword.getPassword()))) {
				JOptionPane.showMessageDialog(passwordFrame,
						"Your password must have at least 8 characters containing at least an uppercase letter, a lowercase letter, and a number.");
			} else {
				user = list.findUser2(emailPassword.getText(), answerPassword.getText());
				user.setPasswd(new String(passwordPassword.getPassword()));
				JOptionPane.showMessageDialog(passwordFrame, "Your password has been reset");
				passwordFrame.dispose();
				JPanel loginPanel = loginPanel();
				loginFrame = setupFrame("LOG IN", loginPanel, true, loginButton);
			}
		}
		if (e.getSource().equals(retrieveUsernameButton)) {
			if (giveEmail.getText().equals("")) {
				JOptionPane.showMessageDialog(usernameFrame, "Please fill in all fields.");
			} else if (!list.doesEmailExist(giveEmail.getText())) {
				JOptionPane.showMessageDialog(usernameFrame, "That email address is not in our System");
			} else {
				user = list.findUser3(giveEmail.getText());
				JOptionPane.showMessageDialog(usernameFrame, "Your username is " + user.getUsername());
				usernameFrame.dispose();
				JPanel loginPanel = loginPanel();
				loginFrame = setupFrame("LOG IN", loginPanel, true, loginButton);
			}
		}
		if (e.getSource().equals(logoutLink)) {
			accountFrame.dispose();
			JPanel loginPanel = loginPanel();
			loginFrame = setupFrame("LOG IN", loginPanel, true, loginButton);
		}
		if (e.getSource().equals(exitPasswordLink)) {
			passwordFrame.dispose();
			JPanel loginPanel = loginPanel();
			loginFrame = setupFrame("LOG IN", loginPanel, true, loginButton);
		}
		if (e.getSource().equals(exitUsernameLink)) {
			usernameFrame.dispose();
			JPanel loginPanel = loginPanel();
			loginFrame = setupFrame("LOG IN", loginPanel, true, loginButton);
		}
	}
}