

import java.util.ArrayList;

/**
 * @author Tuan
 *A list of all users and their information
 */
public class UserList{

private ArrayList<User> userList;
    
    /**
     * Constructor: Builds a userList
     */
    public UserList() {
    	userList = new ArrayList<User>();
//    	File temp = new File("user9.txt");
//    	if(temp.exists()) {
//    		readUsers();
//    	}
    }
    
    public User getUserAtIndex(int index) {
    	if (index >= 0)
    		return userList.get(index);
    	else
    		return null;
    }
    
    public void setUserAtIndex(int index, User user) {
    	userList.set(index, user);
    }
    
    /**
     * @param userName
     * @param password
     * @param email
     * Adds a new user to the list if that user doesn't already exist
     * (their username or email doesn't already exist)
     */
    public void addUser(String userName, String password, String email){
    	if (!doesUserNameExist(userName) && !doesEmailExist(email)) 
    		userList.add(new User(userName,password,email));
//    		writeUsers();
    }
    
    /**
     * @param userName
     * @return a boolean
     * Checks if a username already exists
     */
    public boolean doesUserNameExist(String userName){
    	for (User user: userList) {
    		if(user.matchUserName(userName)) {   
    			return true;   
    		}	
    	}
       return false;
    }
    
    /**
     * @param currentUser, userName
     * @return a boolean
     * Checks if a username already exists.
     * If the input username is the same as the currentUser's username, it will return false.
     * It means the current user's username is still a valid username/does not count as
     * invalid because it already exists.
     */
    public boolean doesUserNameExist2(User currentUser, String userName){
    	if (currentUser.matchUserName(userName))
    		return false;
    	for (User user: userList) {
    		if(user.matchUserName(userName)) {   
    			return true;   
    		}	
    	}
       return false;
    }
    
    /**
     * @param userName
     * @param password
     * @return a User object
     * Searches the list and find the user that has the matching username and password
     */
    public User findUser(String userName, String password){
    	for (User user: userList) {
    		if(user.isValidLogin(userName, password)) {   
    			return user;   
    		}	
    	}
       return null;
    }
    
    /**
     * @param userName
     * @param password
     * @return a User object
     * Searches the list and find the user that has the matching username and password
     */
    public User findUser2(String email, String answer){
    	for (User user: userList) {
    		if(user.isAuthentic(email, answer)) {   
    			return user;   
    		}	
    	}
       return null;
    }
    
//    /**
//     * @param userName
//     * @param password
//     * @return the index of a user or -1 if user not found
//     * Searches the list and find the index of the user that has the matching username and password
//     */
//    public int findUserIndex(String userName, String password){
//    	for (int i = 0; i < userList.size(); i++) {
//    		User user = userList.get(i);
//    		if(user.isValidLogin(userName, password)) {   
//    			return i;   
//    		}	
//    	}
//       return -1;
//    }
//    
//    /**
//     * @param email
//     * @param password
//     * @return the index of a user or -1 if user not found
//     * Searches the list and find the index of the user that has the matching email and (security question) answer
//     */
//    public int findUserIndex2(String email, String answer){
//    	for (int i = 0; i < userList.size(); i++) {
//    		User user = userList.get(i);
//    		if(user.isAuthentic(email, answer)) {   
//    			return i;   
//    		}	
//    	}
//       return -1;
//    }
    
    /**
     * @param currentUser, email
     * @return a boolean
     * Checks if an email already exists
     * If the input email is the same as the currentUser's email, it will return false.
     * It means the current user's email is still a valid email/does not count as
     * invalid because it already exists.
     */
    public boolean doesEmailExist2(User currentUser, String email){
    	if (currentUser.matchEmail(email))
    		return false;
    	for (User user: userList)
    		if(user.matchEmail(email))   
    			return true;   
       return false;
    }
    
    /**
     * @param email
     * @return a boolean
     * Checks if an email already exists
     */
    public boolean doesEmailExist(String email){
    	for (User user: userList)
    		if(user.matchEmail(email))   
    			return true;   
       return false;
    }
    
//    /**
//     * write userList to a file so it can be retrieved
//     */
//    private void writeUsers() {
//    	try {
//    		FileOutputStream users=new FileOutputStream("user9.txt");
//    		ObjectOutputStream write = new ObjectOutputStream(users);
//    		write.writeObject(userList);
//			write.close();
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//    }
//    /**
//     * retrieves userList from file
//     */
//    private void readUsers() {
//    	try {
//			FileInputStream  users= new FileInputStream("user9.txt");
//			ObjectInputStream read= new ObjectInputStream(users);
//			userList= (ArrayList<User>) read.readObject();
//			read.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }
}