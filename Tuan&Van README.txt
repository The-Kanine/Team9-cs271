Tuan & Van README

1. User.java
New external variables: answer
New methods: getAnswer(), setAnswer(), matchAnswer(), and isAuthentic()

2. UserTest.java
New method: testSecurityQuestion()
Changes to testNewAccount()

3. UserList.java
New methods: doesUserNameExist2(), doesEmailExist2(), findUserIndex(), findUserIndex2(),getUserAtIndex(),
and setUserAtIndex()

!!!!!!!!!!!!!!!!Please use!!!!!!!!!!!!!!!!
getUserAtIndex() and setUserAtIndex()
findUserIndex() for criteria 2.4
doesUserNameExist2() for criteria 3.4
doesEmailExist2() for criteria 3.5
findUserIndex2() for criteria 5.6

We're going to operate on indices.
The steps are:

1. Find the user of interest's index
Ex (after a valid login): int index = findUserIndex(userLogIn.getText(), new String(passwordLogIn.getPassword()));

2. Assign the user at that index to a new User object
Ex: User user = list.getUserAtIndex(index);

3. Make changes to that new User object 
Ex (after the user editted their username): user.setUserName(userNameEdit.getText());

4. Set the original user to the new User object (setUserAtIndex()).
Ex: list.setUserAtIndex(index, user);

So we cannot lose the original user's index at any point.
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
Check the spreadsheet for more info

4. UserListTest.java
No new method. Changes to current methods (tests for new UserList methods).

5. New test classes               ***PLEASE READ!***
- Above each test case, we put what the expected (pop-up) message should be. We also put the acceptance criteria
number there (Edit, forgotUName & forgotPass).
- Each test case is independent now. You can comment out the test cases that you don't need.
- We have also updated the acceptance criteria for story 3, 4, and 5. So if you are confused about the design,
you can check the spreadsheet.
- You have to name the buttons and text fields to what we have below or the test class will always have errors
and won’t run.

a. Edit account
Panel: accountPanel (not new)
Button in accountPanel: editButton (not new)
New buttons in accountPanel: doneButton, logOutButton
New text fields in accountPanel: userNameEdit, emailEdit, answerEdit

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
New text fields in SecurityQuestionPanel: forgotPEmail, forgotPAnswer
New buttons in ResetPasswordPanel: newPassword
New text fields in ResetPasswordPanel: resetPasswordButton, resetPasswordCancelButton
