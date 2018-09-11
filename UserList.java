package codepack;

import java.util.ArrayList;

/**
 * @author Tuan
 *A list of all users and their information
 */
public class UserList {

private ArrayList<User> userList;
    
    /**
     * Constructor: Builds a userList
     */
    public UserList() {
    	userList = new ArrayList<User>();
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
    
    public User findUser(String userName, String password){
    	for (User user: userList) {
    		if(user.isValidLogin(userName, password)) {   
    			return user;   
    		}	
    	}
       return null;
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
}
