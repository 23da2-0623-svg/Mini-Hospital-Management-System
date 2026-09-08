class QueueNode {
    Patient patient;
    QueueNode next;

    public QueueNode(Patient patient) {
        this.patient = patient;
        this.next = null;
    }
}

public class EmergencyQueue {
    private QueueNode front, rear;

    public EmergencyQueue() {
        this.front = this.rear = null;
    }

    public void enqueue(Patient patient) {
        QueueNode newNode = new QueueNode(patient);
        if (this.rear == null) {
            this.front = this.rear = newNode;
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
    }

    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        Patient patient = this.front.patient;
        this.front = this.front.next;
        if (this.front == null) this.rear = null;
        return patient;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("No patients waiting in Emergency Queue.");
            return;
        }
        QueueNode temp = front;
        System.out.println("--- Emergency Queue (Waiting Patients) ---");
        while (temp != null) {
            System.out.println(temp.patient);
            temp = temp.next;
        }
    }
}