import junit.framework.TestCase;

/**
 * @author Tuan
 * Test class for UserList class
 */
public class UserListTest extends TestCase {

	private UserList userList;
	
	protected void setUp() throws Exception {
		super.setUp();
		userList = new UserList();
		userList.addUser("Tuan","Bronco2020","tuan@boisestate.edu");
	}

	public void testExistingUserAccount() {
		assertTrue(userList.doesUserNameExist("Tuan"));
		assertTrue(userList.doesEmailExist("tuan@boisestate.edu"));
	}

	public void testNonExistantUserAccount() {
		assertFalse(userList.doesUserNameExist("Van"));
		assertFalse(userList.doesEmailExist("Van@boisestate.edu"));
	}

}
