public class Main {
    public static void main(String[] args) {
        // Create a new UserManagement object
        UserManagement userManagement = new UserManagement();
        // Create a new User object
        User user = new User("john_doe", true);
        // Add the user to the userManagement object
        userManagement.addUser(user);
        // Get the user from the userManagement object
        User retrievedUser = userManagement.getUser("john_doe");
        // Print the retrieved user
        System.out.println(retrievedUser);

        // Create a new TaskManagement object
        TaskManagement taskManagement = new TaskManagement();
        // Create a new Task object
        Task task = new Task("Task 1", false);
        // Add the task to the taskManagement object
        taskManagement.addTask(task);
        // Get the task from the taskManagement object
        Task retrievedTask = taskManagement.getTask("Task 1");
        // Print the retrieved task
        System.out.println(retrievedTask);
    }
    
}
