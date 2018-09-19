



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Tuan, Van
 * Test class for Team9GUI (Edit Account). The user has to manually close each pop-up message
 * (by clicking OK) after each test case.
 */
public class EditAccountTest {

	public Team9GUI team9GUI = null;

	@Before
	public void setUp() throws Exception {
		team9GUI = new Team9GUI();
		
		//sign-up
		// Expected message: "Your account has been created!"
		// Switches to LoginPanel
		team9GUI.userSignUp.setText("name");
		team9GUI.emailSignUp.setText("name@gmail.com");
		team9GUI.passwordSignUp.setText("Bronco2020");
		team9GUI.signUpButton.doClick();
		
		//sign-up 2
		// Expected message: "Your account has been created!"
		// Switches to LoginPanel
		team9GUI.signUpLink.doClick();
		team9GUI.userSignUp.setText("name2");
		team9GUI.emailSignUp.setText("name2@gmail.com");
		team9GUI.passwordSignUp.setText("Bronco2020");
		team9GUI.signUpButton.doClick();
		
		//log-in
		// Expected message: "You have logged in!"
		// Switches to accountPanel
		team9GUI.userLogIn.setText("name");
		team9GUI.passwordLogIn.setText("Bronco2020");
		team9GUI.loginButton.doClick();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	// 3.2 & 3.3
	// For the first time, expected message "Please fill in all fields." 
	// as the answer field for the security question is empty
	public void accountNoEdit() {
		team9GUI.editButton.doClick();
		team9GUI.editButton.doClick();
	}
	
	@Test
	// 3.7
	// Answer the security question without touching any other fields
	// Expected message "Your account has been updated."
	public void answerEdit() {
		team9GUI.editButton.doClick();
		team9GUI.answerEdit.setText("Watermelon");
		team9GUI.editButton.doClick();
	}	
	
	@Test
	// 3.2 & 3.3
	// Expected message: "Please fill in all fields."
	public void editUserNameEmpty() {
		team9GUI.editButton.doClick();
		team9GUI.answerEdit.setText("Watermelon");
		team9GUI.usernameEdit.setText("");
		team9GUI.editButton.doClick();
	}
	
	@Test
	// 3.3
	// Expected message: "Please fill in all fields."
	public void editEmailEmpty() {
		team9GUI.editButton.doClick();
		team9GUI.answerEdit.setText("Watermelon");
		team9GUI.usernameEdit.setText("name2");
		team9GUI.emailEdit.setText("");
		team9GUI.editButton.doClick();
	}
	
	@Test
	// 3.4
	// Expected message: "This username already exists in our system."
	public void editUserNameUsed() {
		team9GUI.editButton.doClick();
		team9GUI.answerEdit.setText("Watermelon");
		team9GUI.usernameEdit.setText("name2");
		team9GUI.emailEdit.setText("name3@gmail.com");
		team9GUI.editButton.doClick();
	}
	
	@Test
	// 3.5
	// Expected message: "This email already exists in our system."
	public void editEmailUsed() {
		team9GUI.editButton.doClick();
		team9GUI.answerEdit.setText("Watermelon");
		team9GUI.usernameEdit.setText("name3");
		team9GUI.emailEdit.setText("name2@gmail.com");
		team9GUI.editButton.doClick();
	}
	
	@Test
	// 3.6
	// Expected message: "The email address provided was not valid."
	public void editEmailInvalid() {
		team9GUI.editButton.doClick();
		team9GUI.answerEdit.setText("Watermelon");
		team9GUI.usernameEdit.setText("name3");
		team9GUI.emailEdit.setText("name3gmail.com");
		team9GUI.editButton.doClick();
	}
	
	@Test
	// 3.7
	// Expected message: "Your account has been updated."
	public void editEmailValid() {
		team9GUI.editButton.doClick();
		team9GUI.answerEdit.setText("Watermelon");
		team9GUI.usernameEdit.setText("name3");
		team9GUI.emailEdit.setText("name3@gmail.com");
		team9GUI.editButton.doClick();
	}
	
	@Test
	// 3.1
	// No expected message. Go back to LoginPanel
	public void logout() {
		team9GUI.logoutLink.doClick();
	}
}