import java.util.LinkedList;

public class TaskManagement {
    private LinkedList<Task> tasks = new LinkedList<Task>();

    public void addTask(Task task) {
        tasks.add(task);
    }
    public void removeTask(Task task) {
        tasks.remove(task);
    }
    public void updateTask(Task task) {
        for (Task t : tasks) {
            if (t.getTaskName().equals(task.getTaskName())) {
                t.setCompleted(task.isCompleted());
            }
        }
    }
    public Task getTask(String taskName) {
        for (Task t : tasks) {
            if (t.getTaskName().equals(taskName)) {
                return t;
            }
        }
        return null;
    }
    public LinkedList<Task> getAllTasks() {
        return tasks;
    }
    public LinkedList<Task> getCompletedTasks() {
        LinkedList<Task> completedTasks = new LinkedList<Task>();
        for (Task t : tasks) {
            if (t.isCompleted()) {
                completedTasks.add(t);
            }
        }
        return completedTasks;
    }

    // Method to get all incomplete tasks from the tasks LinkedList
    public LinkedList<Task> getIncompleteTasks() {
        LinkedList<Task> incompleteTasks = new LinkedList<Task>();
        for (Task t : tasks) {
            if (!t.isCompleted()) {
                incompleteTasks.add(t);
            }
        }
        return incompleteTasks;
    }


}
