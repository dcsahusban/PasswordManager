package controller;

/**
 *
 * @author husban
 * @author harshit
 */

public abstract class FormValidater {
    
    public static boolean validateUsername(String username) {
        return username.matches("^(?=[a-zA-Z0-9._]{5,20}$)(?!.*[_.]{2})[^_.].*[^_.]$");
    }
    
    public static boolean validatePassword(String password) {
        return password.length() >= 8 && (!password.contains(" "));
    }
    
    public static boolean validateEmail(String email) {
        return email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
    }
    
}
