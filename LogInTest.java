import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Tuan, Van
 * Test class for Team9GUI (Log-in). The user has to manually close each pop-up message
 * (by clicking OK) after each test case.
 */
public class LogInTest {

	public Team9GUI team9GUI = null;

	@Before
	public void setUp() throws Exception {
		team9GUI = new Team9GUI();
		
		//sign-up
		team9GUI.userSignUp.setText("name");
		team9GUI.emailSignUp.setText("name@gmail.com");
		team9GUI.passwordSignUp.setText("Bronco2020");
		team9GUI.signUpButton.doClick();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	// Expected message: "Please fill in all fields."
	public void emptyLoginFields() {
		team9GUI.loginButton.doClick();
	}
	
	@Test
	// Expected message: "The username and password do not match."
	public void nameAndPasswordNotMatch() {
		team9GUI.userLogIn.setText("name");
		team9GUI.passwordLogIn.setText("Idaho2020");
		team9GUI.loginButton.doClick();
	}
	
	@Test
	// Expected message: "You have logged in!"
	// Switches to accountPanel
	public void validLogin() {
		team9GUI.userLogIn.setText("name");
		team9GUI.passwordLogIn.setText("Bronco2020");
		team9GUI.loginButton.doClick();
	}
}