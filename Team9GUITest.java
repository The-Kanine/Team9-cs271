import org.junit.Test;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.TestHelper;

/**
 * @author Tuan, Van
 * Test class for Team9GUI. The user has to manually close each pop-up message
 * (by clicking OK) after each test case.
 */
public class Team9GUITest extends JFCTestCase  {
	private Team9GUI team9GUI = null;
	private TestHelper helper = null;
	
	protected void setUp() throws Exception {
		super.setUp();
		helper = new JFCTestHelper();
		team9GUI = new Team9GUI();
	}
	
	protected void tearDown() throws Exception {
		team9GUI = null;
		JFCTestHelper.cleanUp(this);
		super.tearDown();
	}
	
	// Expected message: "Please fill in all fields."
	private void emptySignUpFields() {
		team9GUI.signUpButton.doClick();
	}
	
	// Expected message: "The email address provided was not valid."
	private void invalidEmail() {
		team9GUI.userSignUp.setText("name");
		team9GUI.emailSignUp.setText("namegmail.com");
		team9GUI.passwordSignUp.setText("Bronco2020");
		team9GUI.signUpButton.doClick();
	}
	
	// Expected message: "Your password must have at least 8 characters
	// containing at least an uppercase letter, a lowercase letter, and a number."
	private void shortPassword() {
		team9GUI.userSignUp.setText("name");
		team9GUI.emailSignUp.setText("name@gmail.com");
		team9GUI.passwordSignUp.setText("Bsu2020");
		team9GUI.signUpButton.doClick();
	}
	
	// Expected message: "Your password must have at least 8 characters
	// containing at least an uppercase letter, a lowercase letter, and a number."
	private void noUppercasePassword() {
		team9GUI.userSignUp.setText("name");
		team9GUI.emailSignUp.setText("name@gmail.com");
		team9GUI.passwordSignUp.setText("bronco2020");
		team9GUI.signUpButton.doClick();
	}
	
	// Expected message: "Your password must have at least 8 characters
	// containing at least an uppercase letter, a lowercase letter, and a number."
	private void noLowercasePassword() {
		team9GUI.userSignUp.setText("name");
		team9GUI.emailSignUp.setText("name@gmail.com");
		team9GUI.passwordSignUp.setText("BRONCO2020");
		team9GUI.signUpButton.doClick();
	}
	
	// Expected message: "Your password must have at least 8 characters
	// containing at least an uppercase letter, a lowercase letter, and a number."
	private void noDigitPassword() {
		team9GUI.userSignUp.setText("name");
		team9GUI.emailSignUp.setText("name@gmail.com");
		team9GUI.passwordSignUp.setText("BoiseState");
		team9GUI.signUpButton.doClick();
	}
	
	// Expected message: "Your account has been created!"
	// Switches to LoginPanel
	private void validSignUp() {
		team9GUI.userSignUp.setText("name");
		team9GUI.emailSignUp.setText("name@gmail.com");
		team9GUI.passwordSignUp.setText("Bronco2020");
		team9GUI.signUpButton.doClick();
	}
	
	// Swiches to SignUpPanel
	// Expected message: "This username already exists in our system."
	private void usedUserNameSignUp() {
		team9GUI.signUpLink.doClick();
		team9GUI.userSignUp.setText("name");
		team9GUI.emailSignUp.setText("name2@gmail.com");
		team9GUI.passwordSignUp.setText("Bronco2020");
		team9GUI.signUpButton.doClick();
	}
	
	// Expected message: "This email address already exists in our system."
	private void usedEmailSignUp() {
		team9GUI.userSignUp.setText("name2");
		team9GUI.emailSignUp.setText("name@gmail.com");
		team9GUI.passwordSignUp.setText("Bronco2020");
		team9GUI.signUpButton.doClick();
	}
	
	// Expected message: "Your account has been created!"
	// Switches to LoginPanel
	private void validSignUp2() {
		team9GUI.userSignUp.setText("name2");
		team9GUI.emailSignUp.setText("name2@gmail.com");
		team9GUI.passwordSignUp.setText("Bronco2020");
		team9GUI.signUpButton.doClick();
	}
	
	// Expected message: "Please fill in all fields."
	private void emptyLoginFields() {
		team9GUI.loginButton.doClick();
	}
	
	// Expected message: "The username and password do not match."
	private void nameAndPasswordNotMatch() {
		team9GUI.userLogIn.setText("name");
		team9GUI.passwordLogIn.setText("Idaho2020");
		team9GUI.loginButton.doClick();
	}
	
	// Expected message: "You have logged in!"
	// Switches to accountPanel
	private void validLogin() {
		team9GUI.userLogIn.setText("name");
		team9GUI.passwordLogIn.setText("Bronco2020");
		team9GUI.loginButton.doClick();
	}
	
	// 3.2 & 3.3
	// For the first time, expected message "Please fill in all fields." 
	// as the answer field for the security question is empty
	private void accountNoEdit() {
		team9GUI.editButton.doClick();
		team9GUI.doneButton.doClick();
	}
	
	// 3.7
	// Answer the security question without touching any other fields
	// Expected message "Your account has been updated."
	private void answerEdit() {
		team9GUI.answerEdit.setText("Watermelon");
		team9GUI.doneButton.doClick();
	}	

	// 3.2 & 3.3
	// Expected message: "Please fill in all fields."
	private void editUserNameEmpty() {
		team9GUI.editButton.doClick();
		team9GUI.userNameEdit.setText("");
		team9GUI.doneButton.doCLick();
	}
	
	// 3.3
	// Expected message: "Please fill in all fields."
	private void editEmailEmpty() {
		team9GUI.editButton.doClick();
		team9GUI.userNameEdit.setText("name2");
		team9GUI.emailEdit.setText("");
		team9GUI.doneButton.doCLick();
	}
	
	// 3.4
	// Expected message: "This username already exists in our system."
	private void editUserNameUsed() {
		team9GUI.editButton.doClick();
		team9GUI.userNameEdit.setText("name2");
		team9GUI.emailEdit.setText("name3@gmail.com");
		team9GUI.doneButton.doCLick();
	}
	
	// 3.5
	// Expected message: "This email already exists in our system."
	private void editEmailUsed() {
		team9GUI.editButton.doClick();
		team9GUI.userNameEdit.setText("name3");
		team9GUI.emailEdit.setText("name2@gmail.com");
		team9GUI.doneButton.doCLick();
	}
	
	// 3.6
	// Expected message: "The email address provided was not valid."
	private void editEmailInvalid() {
		team9GUI.editButton.doClick();
		team9GUI.emailEdit.setText("name3gmail.com");
		team9GUI.doneButton.doCLick();
	}
	
	// 3.7
	// Expected message: "Your account has been updated."
	private void editEmailValid() {
		team9GUI.emailEdit.setText("name3@gmail.com");
		team9GUI.doneButton.doCLick();
	}
	
	// 3.1
	// No expected message. Go back to LoginPanel
	private void logOut() {
		team9GUI.logOutButton.doClick();
	}
	
	// 4.1 & 4.3
	// forgot username empty email
	// Switches to ForgotUsernamePanel
	// Expected message: "Please fill in all fields."
	private void forgotUEmptyEmail() {
		team9GUI.forgotUsernameButton.doClick();
		team9GUI.confirmEmailButton.doClick();
	}

	// 4.4
	//forgot username non-existing email
	//expect message "The email address provided does not exist in our system."
	private void forgotUNonExistingEmail() {
		team9GUI.forgotUEmail.setText("non-existing email");
		team9GUI.confirmEmailButton.doClick();
	}
	
	// 4.5
	//forgot username existing email
	//expect message "Your username is [corresponding username]"
	private void forgotUExistingEmail() {
		team9GUI.forgotUEmail.setText("name3@gmail.com");
		team9GUI.confirmEmailButton.doClick();
	}
	
	// 4.2
	//forgot username cancel
	// No expect message. Switches back to login screen
	private void forgotUCancel() {
		team9GUI.forgotUCancelButton.doClick();
	}
	
	// 5.1 & 5.3
	// forgot password empty fields
	// Switches to SecurityQuestionPanel
	// Expected message: "Please fill in all fields."
	private void forgotPEmptyFields() {
		team9GUI.forgotPasswordButton.doClick();
		team9GUI.continueButton.doClick();
	}
	
	// 5.2
	//forgot password security question cancel
	// No expect message. Switches back to login screen
	private void securityCancel() {
		team9GUI.securityCancelButton.doClick();
	}

	// 5.1 & 5.4
	//forgot password non-existing email
	// Switches to SecurityQuestionPanel
	//expect message "The email address provided does not exist in our system."
	private void forgotPNonExistingEmail() {
		team9GUI.forgotPasswordButton.doClick();
		team9GUI.forgotPEmail.setText("non-existing email");
		team9GUI.forgotPAnswer.setText("Coconut");
		team9GUI.continueButton.doClick();
	}
	
	// 5.5
	//forgot password existing email, incorrect answer
	//expect message "Your answer is incorrect." 
	private void forgotPIncorrectAnswer() {
		team9GUI.forgotPEmail.setText("name3@gmail.com");
		team9GUI.continueButton.doClick();
	}
	
	// 5.6
	//forgot password existing email, correct answer
	//No expect message. Switches back to ResetPasswordPanel
	private void forgotPCorrectAnswer() {
		team9GUI.forgotPAnswer.setText("Watermelon");
		team9GUI.continueButton.doClick();
	}
	
	// 5.8
	// forgot password empty fields
	// Expected message: "Please fill in all fields."
	private void forgotPEmptyPass() {
		team9GUI.resetPasswordButton.doClick();
	}
	
	// 5.9
	// forgot password short password
	// Expected message: "Your password must have at least 8 characters
	// containing at least an uppercase letter, a lowercase letter, and a number."
	private void shortNewPassword() {
		team9GUI.newPassword.setText("Bsu2020");
		team9GUI.resetPasswordButton.doClick();
	}
	
	// 5.9
	// forgot password no Upper case Password
	// Expected message: "Your password must have at least 8 characters
	// containing at least an uppercase letter, a lowercase letter, and a number."
	private void noUppercaseNewPassword() {
		team9GUI.newPassword.setText("bronco2020");
		team9GUI.resetPasswordButton.doClick();
	}
	
	// 5.9
	// forgot password no Lower case Password
	// Expected message: "Your password must have at least 8 characters
	// containing at least an uppercase letter, a lowercase letter, and a number."
	private void noLowercaseNewPassword() {
		team9GUI.newPassword.setText("BRONCO2020");
		team9GUI.resetPasswordButton.doClick();
	}
	
	// 5.9
	// forgot password no ditgit Password
	// Expected message: "Your password must have at least 8 characters
	// containing at least an uppercase letter, a lowercase letter, and a number."
	private void noDigitnewPassword() {
		team9GUI.newPassword.setText("BoiseState");
		team9GUI.resetPasswordButton.doClick();
	}
	
	// 5.10
	// forgot password valid new password
	// Expected message:  "Your password has been changed."
	private void validNewPassword() {
		team9GUI.newPassword.setText("Bronco2022");
		team9GUI.resetPasswordButton.doClick();
	}
	
	// 5.7
	//forgot password reset password cancel
	// No expect message. Switches back to login screen
	private void resetPasswordCancel() {
		team9GUI.resetPasswordCancelButton.doClick();
	}
	
	public void test() {
		new Team9GUI();
		try {
			emptySignUpFields();
			Thread.sleep(1000);
			
			invalidEmail();
			Thread.sleep(1000);
			
			shortPassword();
			Thread.sleep(1000);
			
			noUppercasePassword();
			Thread.sleep(1000);
			
			noLowercasePassword();
			Thread.sleep(1000);
			
			noDigitPassword();
			Thread.sleep(1000);
			
			validSignUp();
			Thread.sleep(1000);
			
			usedUserNameSignUp();
			Thread.sleep(1000);
			
			usedEmailSignUp();
			Thread.sleep(1000);
			
			emptyLoginFields();
			Thread.sleep(1000);
			
			nameAndPasswordNotMatch();
			Thread.sleep(1000);
			
			validLogin();
			Thread.sleep(1000);
			
			accountNoEdit();
			Thread.sleep(1000);
			
			answerEdit();
			Thread.sleep(1000);

			editUserNameEmpty();
			Thread.sleep(1000);
			
			editEmailEmpty();
			Thread.sleep(1000);
			
			editUserNameUsed();
			Thread.sleep(1000);
			
			editEmailUsed();
			Thread.sleep(1000);
			
			editEmailInvalid();
			Thread.sleep(1000);
			
			editEmailValid();
			Thread.sleep(1000);
			
			logOut();
			Thread.sleep(1000);
			
			forgotUEmptyEmail();
			Thread.sleep(1000);

			forgotUNonExistingEmail();
			Thread.sleep(1000);
			
			forgotUExistingEmail();
			Thread.sleep(1000);
			
			forgotUCancel();
			Thread.sleep(1000);
			
			forgotPEmptyFields();
			Thread.sleep(1000);
			
			securityCancel();
			Thread.sleep(1000);

			forgotPNonExistingEmail();
			Thread.sleep(1000);
			
			forgotPIncorrectAnswer();
			Thread.sleep(1000);
			
			forgotPCorrectAnswer();
			Thread.sleep(1000);
			
			forgotPEmptyPass();
			Thread.sleep(1000);
			
			shortNewPassword();
			Thread.sleep(1000);
			
			noUppercaseNewPassword();
			Thread.sleep(1000);
			
			noLowercaseNewPassword();
			Thread.sleep(1000);
			
			noDigitnewPassword();
			Thread.sleep(1000);
			
			validNewPassword();
			Thread.sleep(1000);
			
			resetPasswordCancel();
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
