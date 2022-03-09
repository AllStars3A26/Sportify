/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author win10
 */
public final class UserSession {
   private static UserSession instance;

    private String userName;
    private String email;
    private int role ;

    private UserSession(String userName, String email, int role) {
        this.userName = userName;
        this.email = email;
        this.role = role;
    }

    public static UserSession getInstance() {
        return instance;
    }

    public static UserSession getInstace(String userName,String email, int role) {
        if(instance == null) {
            instance = new UserSession(userName,email,role);
        }
        return instance;
    }

  

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }


    public void cleanUserSession() {
        userName = "";// or null
         role=0;
         email ="";
         instance=null;
// or null
    }

    @Override
    public String toString() {
        return "UserSession{" + "userName=" + userName + ", email=" + email + ", role=" + role + '}';
    }

  
    
}
