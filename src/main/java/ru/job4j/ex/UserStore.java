package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User usr : users) {
            if (usr.getUsername().equals(login)) {
                return usr;
            }
        }
        throw new UserNotFoundException("user not found");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid() && user.getUsername().length() >= 3) {
            return true;
        }
        throw new UserInvalidException("user not valid");
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsenyev", true)
        };
        try {
            User user = findUser(users, "Petr Arsenyev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException uin) {
            uin.printStackTrace();
        } catch (UserNotFoundException enf) {
            enf.printStackTrace();
        }

    }
}
