import java.util.LinkedList;

public class UserManagement {
    private LinkedList<User> users = new LinkedList<User>();

    public void addUser(User user) {
        users.add(user);
    }
    public void removeUser(User user) {
        users.remove(user);
    }
    public void updateUser(User user) {
        for (User u : users) {
            if (u.getUsername().equals(user.getUsername())) {
                u.setIsActive(user.getIsActive());
            }
        }
    }
    public User getUser(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
}