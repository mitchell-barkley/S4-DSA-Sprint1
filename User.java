public class User {
    private String username;
    private boolean isActive;
    private TaskManagement taskList = new TaskManagement();

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
    public int getTaskListSize() {
        return taskList.getSize();
    }
    public void addTask(Task task) {
        taskList.addTask(task, taskList.getSize() + 1);
    }
    public void changeTaskStatus(String taskName, boolean status) {
        if (taskList.getTask(taskName) != null) {
            taskList.getTask(taskName).setIsCompleted(status);
        } else {
            System.out.println("Task not found.");
        }
    }

    @Override
    public String toString() {
        return "User: " + username + "\nActive: " + isActive;
    }
}
