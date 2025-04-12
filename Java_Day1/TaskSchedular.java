class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;
    Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}
class CircularLinkedList {
    Task head = null;
    public void addTask(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }
    }
    public void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (position == 0) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
        } else {
            Task temp = head;
            int count = 0;
            while (temp != null && count < position - 1) {
                temp = temp.next;
                count++;
            }
            if (temp != null) {
                newTask.next = temp.next;
                temp.next = newTask;
            }
        }
    }
    public void removeTask(int taskId) {
        if (head == null) return;
        Task temp = head;
        Task prev = null;
        if (temp.taskId == taskId) {
            while (temp.next != head) {
                temp = temp.next;
            }
            if (head == head.next) {
                head = null;
            } else {
                temp.next = head.next;
                head = head.next;
            }
            return;
        }
        do {
            prev = temp;
            temp = temp.next;
        } while (temp != head && temp.taskId != taskId);
        if (temp != head) {
            prev.next = temp.next;
        }
    }
    public void viewCurrentTask() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Task Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Task Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Task ID: " + temp.taskId + ", Task Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No tasks found with the given priority.");
        }
    }
}
public class TaskSchedular {
    public static void main(String[] args) {
        CircularLinkedList taskList = new CircularLinkedList();
        taskList.addTask(1, "Task 1", 2, "2025-04-20");
        taskList.addTask(2, "Task 2", 1, "2025-04-21");
        taskList.addTask(3, "Task 3", 3, "2025-04-22");
        System.out.println("Display all tasks:");
        taskList.displayAllTasks();
        System.out.println("\nSearch for tasks with priority 2:");
        taskList.searchTaskByPriority(2);
        System.out.println("\nRemove task with ID 2:");
        taskList.removeTask(2);
        taskList.displayAllTasks();
        System.out.println("\nView current task and move to next:");
        taskList.viewCurrentTask();
    }
}
