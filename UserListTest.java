import junit.framework.TestCase;

/**
 * @author Tuan
 * Test class for UserList class
 */
public class UserListTest extends TestCase {

	private UserList userList;
	private User newUser = new User("Tuan","Bronco2020","tuan@boisestate.edu");
	
	protected void setUp() throws Exception {
		super.setUp();
		userList = new UserList();
		userList.addUser("Tuan","Bronco2020","tuan@boisestate.edu");
		userList.addUser("keaton","Bronco2020","keaton@boisestate.edu");
	}

	public void testExistingUserAccount() {
		assertTrue(userList.doesUserNameExist("Tuan"));
		assertTrue(userList.doesEmailExist("tuan@boisestate.edu"));
		assertFalse(userList.doesUserNameExist2(newUser,"Tuan"));
		assertFalse(userList.doesEmailExist2(newUser,"tuan@boisestate.edu"));
		assertTrue(userList.doesUserNameExist2(newUser,"keaton"));
		assertTrue(userList.doesEmailExist2(newUser,"keaton@boisestate.edu"));
		User user = userList.findUser("Tuan", "Bronco2020");
		assertTrue(newUser.matchUserName(user.getUsername()));
		assertTrue(newUser.matchEmail(user.getEmail()));
		assertTrue(newUser.matchPassword(user.getPassword()));
	}

	public void testNonExistantUserAccount() {
		assertFalse(userList.doesUserNameExist("Van"));
		assertFalse(userList.doesEmailExist("Van@boisestate.edu"));
		assertFalse(userList.doesUserNameExist2(newUser,"Van"));
		assertFalse(userList.doesEmailExist2(newUser,"Van@boisestate.edu"));
		assertNull(userList.findUser("Tuan", "Idaho2020"));
	}

}
