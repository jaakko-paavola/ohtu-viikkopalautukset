package ohtu.authentication;

import ohtu.data_access.UserDao;
import ohtu.domain.User;
import ohtu.util.CreationStatus;

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

    public CreationStatus createUser(String username, String password, String passwordConfirmation) {
        CreationStatus status = new CreationStatus();
        
//        if (userDao.findByName(username) != null) {
//            status.addError("username is already taken");
//        }
//
        if (username.length()<3 ) {
            status.addError("username should have at least 3 characters");
	    return status;
        }
//
//        if (status.isOk()) {
//            userDao.add(new User(username, password));
//        }

        Character character;
        for (char c : username.toCharArray()) {
            character = new Character(c);
            if (character.compareTo('a') < 0 || character.compareTo('z') > 0) {
		status.addError("username should only have characters a-z");
		return status;
	    }
        }

        if (password.length() < 8) {
	    status.addError("password should have at least 8 characters");
	    return status;
	}
        for (char c : password.toCharArray()) {
            character = new Character(c);
            if (character.compareTo('a') < 0 || character.compareTo('z') > 0) {
		if (!password.equals(passwordConfirmation)) {
		    status.addError("password and password confirmation do not match");
		    break;
		}
                userDao.add(new User(username, password));
		return status;
	    }
        }
        status.addError("password should not only have characters a-z");
	return status;
    }
}
