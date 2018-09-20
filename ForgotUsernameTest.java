import org.junit.Before;
import org.junit.Test;

/**
 * @author Tuan, Van
 * Test class for Team9GUI (forgot username). The user has to manually close each pop-up message
 * (by clicking OK) after each test case.
 */
public class ForgotUsernameTest {

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
		
		team9GUI.forgotUsernameLink.doClick();
	}
	
	@Test
	// 4.1 & 4.3
	// forgot username empty email
	// Switches to ForgotUsernamePanel
	// Expected message: "Please fill in all fields."
	public void forgotUEmptyEmail() {
		team9GUI.retrieveUsernameButton.doClick();
	}

	@Test
	// 4.4
	//forgot username non-existing email
	//expect message "The email address provided does not exist in our system."
	public void forgotUNonExistingEmail() {
		team9GUI.giveEmail.setText("non-existing email");
		team9GUI.retrieveUsernameButton.doClick();
	}
	
	@Test
	// 4.5
	//forgot username existing email
	//expect message "Your username is [corresponding username]"
	public void forgotUExistingEmail() {
		team9GUI.giveEmail.setText("name@gmail.com");
		team9GUI.retrieveUsernameButton.doClick();
	}
	
	@Test
	// 4.2
	//forgot username cancel
	// No expect message. Switches back to login screen
	public void forgotUCancel() {
		team9GUI.exitUsernameLink.doClick();
	}
}