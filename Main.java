import java.util.LinkedList;

public class Main {
    private static int taskID = 1;
    private static LinkedList<User> users = new LinkedList<User>();
    private static LinkedList<Task> tasks = new LinkedList<Task>();
    private static LinkedList<Task> completedTasks = new LinkedList<Task>();
    private static LinkedList<Task> incompleteTasks = new LinkedList<Task>();
    private static LinkedList<Task> allTasks = new LinkedList<Task>();

    public static void main(String[] args) {
        System.out.println("Welcome to the To-Do List Application!");
        System.out.println("======================================");
        do {
            System.out.println("Please enter your username: ");
            String username = System.console().readLine();
            User user = new User(username, true);
            UserManagement userManagement = new UserManagement();
            userManagement.addUser(user);
            String ifContinue = "yes";
            do {
                System.out.println("Please enter the task name: ");
                String taskName = System.console().readLine();
                if (taskName.isEmpty()) {
                    System.out.println("Task name cannot be empty.");
                }else {
                    Task task = new Task(taskID, taskName, "", false);
                    user.addTask(task);
                }
                System.out.println("Please enter the task description: ");
                String taskDescription = System.console().readLine();
                if (taskDescription.isEmpty()) {
                    System.out.println("Task description cannot be empty.");
                } else {
                    Task task = new Task(taskID, taskName, taskDescription, false);
                    user.addTask(task);
                    addTaskToLists(task);
                }
                System.out.println("Would you like to add another task? (yes/no)");
                ifContinue = System.console().readLine();
            } while (ifContinue.equals("yes"));
            if (ifContinue.equals("no")) {
                displayMenu();
            }
            System.out.println("Would you like to add another user? (yes/no)");
        } while (System.console().readLine().equals("yes"));
        main(args);
    }

    public static void displayMenu() {
        System.out.println("Please select an option:");
        System.out.println("1. Add a task");
        System.out.println("2. View all tasks");
        System.out.println("3. View completed tasks");
        System.out.println("4. View incomplete tasks");
        System.out.println("5. Mark a task as complete");
        System.out.println("6. Switch User");
        System.out.println("7. Exit");
        String option = System.console().readLine();
        System.out.println("");
        switch (option) {
            case "1":
                addTask();
                break;
            case "2":
                viewAllTasks();
                break;
            case "3":
                viewCompletedTasks();
                break;
            case "4":
                viewIncompleteTasks();
                break;
            case "5":
                markTaskComplete();
                break;
            case "6":
                userMenu();
                break;
            case "7":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                displayMenu();
                break;
        }
    }

    public static void addTask() {
        taskID = tasks.size() + 1;
        System.out.println("Please enter the task name: ");
        String taskName = System.console().readLine();
        if (taskName.isEmpty()) {
            System.out.println("Task name cannot be empty.");
            addTask();
        } else {
            System.out.println("Please enter the task description: ");
            String taskDescription = System.console().readLine();
            if (taskDescription.isEmpty()) {
                System.out.println("Task description cannot be empty.");
                addTask();
            } else {
                Task task = new Task(taskID, taskName, taskDescription, false);
                addTaskToLists(task);
                displayMenu();
            }
        }
    }

    public static void addTaskToLists(Task task) {
        tasks.add(task);
        allTasks.add(task);
        incompleteTasks.add(task);
    }

    public static void viewAllTasks() {
        System.out.println("All tasks:");
        for (Task t : allTasks) {
            System.out.println(t + "\n");
        }
        System.out.println("");
        displayMenu();
    }

    public static void viewCompletedTasks() {
        System.out.println("Completed tasks:");
        for (Task t : completedTasks) {
            System.out.println(t + "\n");
        }
        System.out.println("");
        displayMenu();
    }

    public static void viewIncompleteTasks() {
        System.out.println("Incomplete tasks:");
        for (Task t : incompleteTasks) {
            System.out.println(t + "\n");
        }
        System.out.println("");
        displayMenu();
    }

    public static void markTaskComplete() {
        System.out.println("Please enter the task number: ");
        int taskID = Integer.parseInt(System.console().readLine());
        if (taskID > 0 && taskID <= tasks.size()) {
            tasks.get(taskID - 1).completeTask();
            completedTasks.add(tasks.get(taskID - 1));
            incompleteTasks.remove(tasks.get(taskID - 1));
            displayMenu();
        } else {
            System.out.println("Invalid task number. Please try again.");
            markTaskComplete();
        }
    }

    public static void displayTasks(LinkedList<Task> taskList) {
        for (Task t : taskList) {
            System.out.println(t + "\n");
        }
    }

    private static void userMenu() {
        System.out.println("Please select an option:");
        System.out.println("1. Add a user");
        System.out.println("2. View all users");
        System.out.println("3. View active users");
        System.out.println("4. View inactive users");
        System.out.println("5. Options for tasks");
        System.out.println("6. Exit");
        String option = System.console().readLine();
        switch (option) {
            case "1":
                addUser();
                break;
            case "2":
                viewAllUsers();
                break;
            case "3":
                viewActiveUsers();
                break;
            case "4":
                viewInactiveUsers();
                break;
            case "5":
                displayMenu();
                break;
            case "6":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                userMenu();
                break;
        }
    }

    private static void addUser() {
        System.out.println("Please enter the username: ");
        String username = System.console().readLine();
        User user = new User(username, true);
        UserManagement userManagement = new UserManagement();
        userManagement.addUser(user);
        users.add(user);
        userMenu();
    }

    private static void viewAllUsers() {
        for (User u : users) {
            System.out.println(u + "\n");
        }
        userMenu();
    }

    private static void viewActiveUsers() {
        for (User u : users) {
            if (u.getIsActive()) {
                System.out.println(u + "\n");
            }
        }
        userMenu();
    }

    private static void viewInactiveUsers() {
        for (User u : users) {
            if (!u.getIsActive()) {
                System.out.println(u + "\n");
            }
        }
        userMenu();
    }
}
