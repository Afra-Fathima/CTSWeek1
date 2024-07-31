// Task Class
class Task {
    private String taskId;
    private String taskName;
    private String status;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskId + ", Task Name: " + taskName + ", Status: " + status;
    }
}

// Node Class for Singly Linked List
class Node {
    Task data;
    Node next;

    public Node(Task data) {
        this.data = data;
        this.next = null;
    }
}

// Singly Linked List for Task Management
class TaskLinkedList {
    private Node head;

    public TaskLinkedList() {
        this.head = null;
    }

    // Add a new task
    public void addTask(Task task) {
        Node newNode = new Node(task);
        newNode.next = head;
        head = newNode;
    }

    // Search for a task by ID
    public Task searchTaskById(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.data.getTaskId().equals(taskId)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse all tasks
    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // Delete a task by ID
    public void deleteTaskById(String taskId) {
        if (head == null) return;

        if (head.data.getTaskId().equals(taskId)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.getTaskId().equals(taskId)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }

        System.out.println("Task with ID " + taskId + " not found.");
    }
}

// Main Class
public class TaskManagementSystem {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        taskList.addTask(new Task("T001", "Design the UI", "In Progress"));
        taskList.addTask(new Task("T002", "Develop the backend", "Not Started"));
        taskList.addTask(new Task("T003", "Test the application", "In Progress"));

        System.out.println("All Tasks:");
        taskList.traverseTasks();

        System.out.println("\nSearch Task by ID (T002):");
        Task task = taskList.searchTaskById("T002");
        if (task != null) {
            System.out.println(task);
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nDeleting Task with ID (T002):");
        taskList.deleteTaskById("T002");

        System.out.println("\nAll Tasks after deletion:");
        taskList.traverseTasks();
    }
}
