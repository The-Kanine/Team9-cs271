package codepack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Tuan, Van
 * Test class for Team9GUI (Sign-up). The user has to manually close each pop-up message
 * (by clicking OK) after each test case.
 */
public class SignUpTest {

	public Team9GUI team9GUI = null;

	@Before
	public void setUp() throws Exception {
		team9GUI = new Team9GUI();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	// Expected message: "Please fill in all fields."
	public void emptySignUpFields() {
		team9GUI.signUpButton.doClick();
	}
	
	@Test
	// Expected message: "The email address provided was not valid."
	public void invalidEmail() {
		team9GUI.userSignUp.setText("name");
		team9GUI.emailSignUp.setText("namegmail.com");
		team9GUI.passwordSignUp.setText("Bronco2020");
		team9GUI.signUpButton.doClick();
	}
	
	@Test
	// Expected message: "Your password must have at least 8 characters
	// containing at least an uppercase letter, a lowercase letter, and a number."
	public void shortPassword() {
		team9GUI.userSignUp.setText("name");
		team9GUI.emailSignUp.setText("name@gmail.com");
		team9GUI.passwordSignUp.setText("Bsu2020");
		team9GUI.signUpButton.doClick();
	}
	
	@Test
	// Expected message: "Your password must have at least 8 characters
	// containing at least an uppercase letter, a lowercase letter, and a number."
	public void noUppercasePassword() {
		team9GUI.userSignUp.setText("name");
		team9GUI.emailSignUp.setText("name@gmail.com");
		team9GUI.passwordSignUp.setText("bronco2020");
		team9GUI.signUpButton.doClick();
	}
	
	@Test
	// Expected message: "Your password must have at least 8 characters
	// containing at least an uppercase letter, a lowercase letter, and a number."
	public void noLowercasePassword() {
		team9GUI.userSignUp.setText("name");
		team9GUI.emailSignUp.setText("name@gmail.com");
		team9GUI.passwordSignUp.setText("BRONCO2020");
		team9GUI.signUpButton.doClick();
	}
	
	@Test
	// Expected message: "Your password must have at least 8 characters
	// containing at least an uppercase letter, a lowercase letter, and a number."
	public void noDigitPassword() {
		team9GUI.userSignUp.setText("name");
		team9GUI.emailSignUp.setText("name@gmail.com");
		team9GUI.passwordSignUp.setText("BoiseState");
		team9GUI.signUpButton.doClick();
	}
	
	@Test
	// Expected message: "Your account has been created!"
	// Switches to LoginPanel
	public void validSignUp() {
		team9GUI.userSignUp.setText("name");
		team9GUI.emailSignUp.setText("name@gmail.com");
		team9GUI.passwordSignUp.setText("Bronco2020");
		team9GUI.signUpButton.doClick();
	}
	
	@Test
	// Expected message: "Your account has been created!"
	// Expected message: "This username already exists in our system."
	public void usedUserNameSignUp() {
		//sign-up
		team9GUI.userSignUp.setText("name");
		team9GUI.emailSignUp.setText("name@gmail.com");
		team9GUI.passwordSignUp.setText("Bronco2020");
		team9GUI.signUpButton.doClick();
		
		//used username
		team9GUI.userSignUp.setText("name");
		team9GUI.emailSignUp.setText("name2@gmail.com");
		team9GUI.passwordSignUp.setText("Bronco2020");
		team9GUI.signUpButton.doClick();
	}
	
	@Test
	// Expected message: "Your account has been created!"
	// Expected message: "This email address already exists in our system."
	public void usedEmailSignUp() {
		//sign-up
		team9GUI.userSignUp.setText("name");
		team9GUI.emailSignUp.setText("name@gmail.com");
		team9GUI.passwordSignUp.setText("Bronco2020");
		team9GUI.signUpButton.doClick();
		
		//used email
		team9GUI.userSignUp.setText("name2");
		team9GUI.emailSignUp.setText("name@gmail.com");
		team9GUI.passwordSignUp.setText("Bronco2020");
		team9GUI.signUpButton.doClick();
	}
}