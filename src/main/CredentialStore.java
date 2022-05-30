/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author husbankhalid
 */
public class CredentialStore {
    
    private static String loggedInUser = null;
    
    //Only single user to saved
    static public void setLoggedInUser(String user){
        CredentialStore.loggedInUser = user;
    }
    
    static public String getLoggedInUser(String user){
        return CredentialStore.loggedInUser;
    }
           
}
