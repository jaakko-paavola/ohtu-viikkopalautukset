package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password
        if (username.length() < 3) 
            return true;
        Character character;
        for (char c : username.toCharArray()) {
            character = new Character(c);
            if (character.compareTo('a') < 0 || character.compareTo('z') > 0)
                return true;
        }

        if (password.length() < 8)
            return true;
        for (char c : password.toCharArray()) {
            character = new Character(c);
            if (character.compareTo('a') < 0 || character.compareTo('z') > 0)
                return false;
        }
        return true;
    }

}
