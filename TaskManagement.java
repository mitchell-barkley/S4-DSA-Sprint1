import java.util.LinkedList;

public class TaskManagement {
    private LinkedList<Task> tasks = new LinkedList<Task>();

    public void addTask(Task task, int taskNumber) {
        tasks.add(task);

    }
    public int getSize() {
        return tasks.size();
    }
    public Task getTask(String taskName) {
        for (Task t : tasks) {
            if (t.getTaskName().equals(taskName)) {
                return t;
            }
        }
        return null;
    }
    public void updateTask(int task) {
        tasks.get(task - 1).setIsCompleted(true);
    }
    public LinkedList<Task> getAllTasks() {
        return tasks;
    }
    public LinkedList<Task> getCompletedTasks() {
        LinkedList<Task> completedTasks = new LinkedList<Task>();
        for (Task t : tasks) {
            if (t.getIsCompleted()) {
                completedTasks.add(t);
            }
        }
        return completedTasks;
    }
    public LinkedList<Task> getIncompleteTasks() {
        LinkedList<Task> incompleteTasks = new LinkedList<Task>();
        for (Task t : tasks) {
            if (!t.getIsCompleted()) {
                incompleteTasks.add(t);
            }
        }
        return incompleteTasks;
    }
    public void displayTasks(LinkedList<Task> taskList) {
        for (Task t : taskList) {
            System.out.println(t + "\n");
        }
    }
}
