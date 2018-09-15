Tuan & Van README

1. User.java
New external variables: answer
New methods: getAnswer(), setAnswer(), and matchAnswer()

2. UserTest.java
New method: testSecurityQuestion()

3. UserList.java
New methods: doesUserNameExist2() and doesEmailExist2()
***Please use these for Story 3 (Edit account)!*** Check the spreadsheet for more info

4. UserListTest.java
No new method. Changes to current methods (tests for new UserList methods).

5. Team9GUITest.java               ***PLEASE READ!***
- We will figure out how to make it into several test cases and not one big test case with many assertions later.
- Above each test case, we put what the expected (pop-up) message should be. We also put the acceptance criteria number there (from 3.1)
- We recommend that you run the test class from start to end every single time, because many test cases rely on the actions of previous test case(s). If you want it to to run faster, just comment out the Thread.sleep(1000)’s. 
- We have also updated the acceptance criteria for story 3, 4, and 5. So if you are confused about the design, you can check the spreadsheet.
- You have to name the buttons and text fields to what we have below or the test class will always have errors and won’t run.

a. Edit account
Panel: accountPanel (not new)
Button (accountPanel): editButton (not new)
New buttons (accountPanel): doneButton, logOutButton
New text fields (accountPanel): userNameEdit, emailEdit

b. Forgot username
Panel: LoginPanel (not new)
New panel (you can name it whatever you want): ForgotUsernamePanel
New buttons in LoginPanel: forgotUsernameButton
New buttons in ForgotUsernamePanel:  confirmEmailButton, forgotUCancelButton
New text field in ForgotUsernamePanel: forgotUEmail

c. Forgot password
Panel: LoginPanel (not new)
New panels (you can name it whatever you want): SecurityQuestionPanel, ResetPasswordPanel
New buttons in LoginPanel: forgotPasswordButton
New buttons in SecurityQuestionPanel: continueButton, securityCancelButton
New text fields in SecurityQuestionPanel: forgotPEmail, forgotPEmail
New buttons in ResetPasswordPanel: newPassword
New text fields in ResetPasswordPanel: resetPasswordButton, resetPasswordCancelButton