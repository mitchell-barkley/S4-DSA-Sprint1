public class User {
    private String username;
    private boolean isActive;

    public User(String username, boolean isActive) {
        this.username = username;
        this.isActive = isActive;
    }

    public String getUsername() {
        return username;
    }
    public boolean getIsActive() {
        return isActive;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    @Override
    public String toString() {
        return "User: " + username + "\nActive: " + isActive;
    }
}
