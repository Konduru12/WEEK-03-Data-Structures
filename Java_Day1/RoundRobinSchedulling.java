class Process {
    int pid;
    int burstTime;
    @SuppressWarnings("unused")
    int priority;
    int remainingTime;
    int waitingTime;
    int turnaroundTime;
    Process next;
    public Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
        this.next = null;
    }
}
class CircularQueue {
    private Process tail = null;
    public void addProcess(int pid, int burstTime, int priority) {
        Process newProcess = new Process(pid, burstTime, priority);
        if (tail == null) {
            tail = newProcess;
            tail.next = tail;
        } else {
            newProcess.next = tail.next;
            tail.next = newProcess;
            tail = newProcess;
        }
    }
    public void removeProcess(int pid) {
        if (tail == null) return;

        Process current = tail;
        Process prev ;

        do {
            prev = current;
            current = current.next;
            if (current.pid == pid) {
                if (current == tail && current.next == tail) {
                    tail = null;
                } else {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev;
                    }
                }
                return;
            }
        } while (current != tail);
    }
    public boolean isEmpty() {
        return tail == null;
    }
    public void simulateRoundRobin(int timeQuantum) {
        if (tail == null) return;
        int totalTime = 0;
        int totalWaiting = 0;
        int totalTurnaround = 0;
        int processCount = 0;
        Process current = tail.next;
        while (!isEmpty()) {
            if (current.remainingTime > 0) {
                System.out.println("Executing Process " + current.pid);
                int execTime = Math.min(timeQuantum, current.remainingTime);
                current.remainingTime -= execTime;
                totalTime += execTime;
                displayQueue();
                if (current.remainingTime == 0) {
                    current.turnaroundTime = totalTime;
                    current.waitingTime = current.turnaroundTime - current.burstTime;
                    totalWaiting += current.waitingTime;
                    totalTurnaround += current.turnaroundTime;
                    System.out.println("Process " + current.pid + " completed.");
                    removeProcess(current.pid);
                    processCount++;
                    if (tail == null) break;
                    current = tail.next;
                } else {
                    current = current.next;
                }
            } else {
                current = current.next;
            }
        }
        double avgWaiting = (double) totalWaiting / processCount;
        double avgTurnaround = (double) totalTurnaround / processCount;
        System.out.printf("\nAverage Waiting Time: %.2f\n", avgWaiting);
        System.out.printf("Average Turnaround Time: %.2f\n", avgTurnaround);
    }
    public void displayQueue() {
        if (tail == null) {
            System.out.println("Queue is empty.");
            return;
        }
        Process current = tail.next;
        System.out.print("Current Queue: ");
        do {
            System.out.print("[PID: " + current.pid + ", Rem: " + current.remainingTime + "] -> ");
            current = current.next;
        } while (current != tail.next);
        System.out.println();
    }
}
public class RoundRobinSchedulling {
    public static void main(String[] args) {
        CircularQueue scheduler = new CircularQueue();
        scheduler.addProcess(1, 6, 2);
        scheduler.addProcess(2, 4, 1);
        scheduler.addProcess(3, 8, 3);
        scheduler.addProcess(4, 5, 2);
        int timeQuantum = 3;
        scheduler.simulateRoundRobin(timeQuantum);
    }
}
