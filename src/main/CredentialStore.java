package main;

/**
 *
 * @author Husban
 * @author Harshit
 */
public class CredentialStore {
    
    private static String loggedInUser = null;
    
    static public void setLoggedInUser(String user) {
        CredentialStore.loggedInUser = user;
    }
    
    static public String getLoggedInUser() {
        return CredentialStore.loggedInUser;
    }
           
}
