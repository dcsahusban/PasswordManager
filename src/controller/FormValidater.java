package controller;

/**
 *
 * @author husban
 * @author harshit
 */

public abstract class FormValidater {
    
    public static boolean validateUsername(String username) {
        // TODO: Use Regex for validation
        return username.length() >= 5 && (!username.contains(" "));
    }
    
    public static boolean validatePassword(String password) {
        // TODO: Use Regex for validation
        return password.length() >= 8 && (!password.contains(" "));
    }
    
    public static boolean validateEmail(String email) {
        // TODO: Use Regex for validation
        return email.length() >= 6 && (!email.contains(" ") && email.contains("@"));
    }
    
}
