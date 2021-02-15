package ru.job4j.ex;

import java.util.Arrays;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (int i = 0; i < users.length; i++) {
            if (login.equals(users[i].getUsername())) {
                rsl = users[i];
            }
        }
        if (rsl == null) {
            throw new UserNotFoundException("Element not found!");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if ((!user.isValid()) || (user.getUsername().length() < 3)) {
            throw new UserInvalidException("Username is invalid");
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            User[] users = {
                    new User("Petr Arsentev", true)
            };
            User user = findUser(users, "Petr Arsentev1");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException eu) {
            eu.printStackTrace();
        } catch (UserNotFoundException en) {
            en.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

   }
}
