
import org.junit.Before;
import org.junit.Test;

/**
 * @author Tuan, Van
 * Test class for Team9GUI (forgot password). The user has to manually close each pop-up message
 * (by clicking OK) after each test case.
 */
public class ForgotPasswordTest {

	public Team9GUI team9GUI = null;

	@Before
	public void setUp() throws Exception {
		team9GUI = new Team9GUI(false);
		
		//sign-up
		// Expected message: "Your account has been created!"
		// Switches to LoginPanel
		team9GUI.userSignUp.setText("name");
		team9GUI.emailSignUp.setText("name@gmail.com");
		team9GUI.passwordSignUp.setText("Bronco2020");
		team9GUI.signUpButton.doClick();
		
		//log-in
		// Expected message: "You have logged in!"
		// Switches to accountPanel
		team9GUI.userLogIn.setText("name");
		team9GUI.passwordLogIn.setText("Bronco2020");
		team9GUI.loginButton.doClick();
		
		//edit answer
		team9GUI.editButton.doClick();
		team9GUI.answerEdit.setText("Watermelon");
		team9GUI.editButton.doClick();
		team9GUI.logoutLink.doClick();
		
		team9GUI.forgotPasswordLink.doClick();
	}
	
	@Test
	// 5.1 & 5.3
	// forgot password empty fields
	// Switches to SecurityQuestionPanel
	// Expected message: "Please fill in all fields."
	public void forgotPEmptyFields() {
		team9GUI.changePasswordButton.doClick();
	}
	
	@Test
	// 5.2
	//forgot password security question cancel
	// No expect message. Switches back to login screen
	public void securityCancel() {
		team9GUI.exitPasswordLink.doClick();
	}

	@Test
	// 5.1 & 5.4
	//forgot password non-existing email
	// Switches to SecurityQuestionPanel
	//expect message "The email address provided does not exist in our system."
	public void forgotPNonExistingEmail() {
		team9GUI.emailPassword.setText("non-existing email");
		team9GUI.answerPassword.setText("Coconut");
		team9GUI.passwordPassword.setText("Bronco2022");
		team9GUI.changePasswordButton.doClick();
	}
	
	@Test
	// 5.5
	//forgot password existing email, incorrect answer
	//expect message "Your answer is incorrect." 
	public void forgotPIncorrectAnswer() {
		team9GUI.emailPassword.setText("name@gmail.com");
		team9GUI.answerPassword.setText("Coconut");
		team9GUI.passwordPassword.setText("Bronco2022");
		team9GUI.changePasswordButton.doClick();
	}
	
	
	@Test
	// 5.8
	// forgot password empty fields
	// Expected message: "Please fill in all fields."
	public void forgotPEmptyPass() {
		team9GUI.emailPassword.setText("name@gmail.com");
		team9GUI.answerPassword.setText("Watermelon");
		team9GUI.changePasswordButton.doClick();
		
	}
	
	@Test
	// 5.9
	// forgot password short password
	// Expected message: "Your password must have at least 8 characters
	// containing at least an uppercase letter, a lowercase letter, and a number."
	public void shortNewPassword() {
		team9GUI.emailPassword.setText("name@gmail.com");
		team9GUI.answerPassword.setText("Watermelon");
		
		
		team9GUI.passwordPassword.setText("Bsu2020");
		team9GUI.changePasswordButton.doClick();
	}
	
	@Test
	// 5.9
	// forgot password no Upper case Password
	// Expected message: "Your password must have at least 8 characters
	// containing at least an uppercase letter, a lowercase letter, and a number."
	public void noUppercaseNewPassword() {
		team9GUI.emailPassword.setText("name@gmail.com");
		team9GUI.answerPassword.setText("Watermelon");
		
		
		team9GUI.passwordPassword.setText("bronco2020");
		team9GUI.changePasswordButton.doClick();
	}
	
	@Test
	// 5.9
	// forgot password no Lower case Password
	// Expected message: "Your password must have at least 8 characters
	// containing at least an uppercase letter, a lowercase letter, and a number."
	public void noLowercaseNewPassword() {
		team9GUI.emailPassword.setText("name@gmail.com");
		team9GUI.answerPassword.setText("Watermelon");
		
		
		team9GUI.passwordPassword.setText("BRONCO2020");
		team9GUI.changePasswordButton.doClick();
	}
	
	@Test
	// 5.9
	// forgot password no ditgit Password
	// Expected message: "Your password must have at least 8 characters
	// containing at least an uppercase letter, a lowercase letter, and a number."
	public void noDigitpasswordPassword() {
		team9GUI.emailPassword.setText("name@gmail.com");
		team9GUI.answerPassword.setText("Watermelon");
		
		team9GUI.passwordPassword.setText("BoiseState");
		team9GUI.changePasswordButton.doClick();
	}
	
	@Test
	// 5.10
	// forgot password valid new password
	// Expected message:  "Your password has been changed."
	public void validNewPassword() {
		team9GUI.emailPassword.setText("name@gmail.com");
		team9GUI.answerPassword.setText("Watermelon");
		team9GUI.passwordPassword.setText("Bronco2022");
		team9GUI.changePasswordButton.doClick();
	}
	
	//@Test
	// 5.7
	//forgot password reset password cancel
	// No expect message. Switches back to login screen
//	public void resetPasswordCancel() {
//		team9GUI.emailPassword.setText("name@gmail.com");
//		team9GUI.answerPassword.setText("Watermelon");
//		team9GUI.exitPasswordLink.doClick();
//	}
}