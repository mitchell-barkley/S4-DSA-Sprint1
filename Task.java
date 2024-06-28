public class Task {
    private int taskID;
    private String taskName;
    private String taskDescription;
    private boolean isCompleted = false;

    public Task(int taskID, String taskName, String taskDescription, boolean isCompleted) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.isCompleted = isCompleted;
    }
    public int getTaskID() {
        return taskID;
    }
    public String getTaskName() {
        return taskName;
    }
    public String getTaskDescription() {
        return taskDescription;
    }
    public boolean getIsCompleted() {
        return isCompleted;
    }
    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
    public void setIsCompleted(boolean completed) {
        isCompleted = completed;
    }
    public void completeTask() {
        isCompleted = true;
    }

    @Override
    public String toString() {
        return "Task " + taskID + ": " + taskName + "\nCompleted: " + isCompleted;
    }
}
