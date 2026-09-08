class StackNode {
    TreatmentRecord record;
    StackNode next;

    public StackNode(TreatmentRecord record) {
        this.record = record;
        this.next = null;
    }
}

public class TreatmentStack {
    private StackNode top;

    public TreatmentStack() {
        this.top = null;
    }

    public void push(TreatmentRecord record) {
        StackNode newNode = new StackNode(record);
        newNode.next = top;
        top = newNode;
    }

    public TreatmentRecord pop() {
        if (isEmpty()) {
            System.out.println("Treatment Stack is empty!");
            return null;
        }
        TreatmentRecord record = top.record;
        top = top.next;
        return record;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("No completed treatment records found.");
            return;
        }
        StackNode temp = top;
        System.out.println("--- Completed Treatment History (LIFO) ---");
        while (temp != null) {
            System.out.println(temp.record);
            temp = temp.next;
        }
    }
}