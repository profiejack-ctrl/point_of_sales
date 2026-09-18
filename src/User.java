/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */

/**
 *
 * @author ProfieJack
 */
public class User {
    
    private User() {
    }
    
    public static User getInstance() {
        return UserHolder.INSTANCE;
    }
    
    private static class UserHolder {

        private static final User INSTANCE = new User();
    }
}
