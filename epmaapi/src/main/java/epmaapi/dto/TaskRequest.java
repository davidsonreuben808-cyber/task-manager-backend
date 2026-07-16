package epmaapi.dto;

public class TaskRequest {
    
    private int task_id;
    private String task_name;
    private String description;
    private String due_date;
    private String priority;
    private String status;
    private int user_id;


    public int getTask_id() {
    return task_id;
    }

    public void setTask_id(int task_id) {
    this.task_id = task_id;
    }
    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
