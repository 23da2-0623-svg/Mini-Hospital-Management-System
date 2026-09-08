class ListNode {
    Visit visit;
    ListNode next;

    public ListNode(Visit visit) {
        this.visit = visit;
        this.next = null;
    }
}

public class PatientVisitLinkedList {
    private ListNode head;

    public void addVisit(Visit visit) {
        ListNode newNode = new ListNode(visit);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void removeVisit(int visitId) {
        if (head == null) return;

        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            System.out.println("Visit ID " + visitId + " removed.");
            return;
        }

        ListNode temp = head;
        while (temp.next != null && temp.next.visit.getVisitId() != visitId) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Visit ID " + visitId + " removed.");
        } else {
            System.out.println("Visit ID not found!");
        }
    }

    public Visit searchVisit(int visitId) {
        ListNode temp = head;
        while (temp != null) {
            if (temp.visit.getVisitId() == visitId) return temp.visit;
            temp = temp.next;
        }
        return null;
    }

    public void displayVisits() {
        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }
        ListNode temp = head;
        System.out.println("--- Patient Visit History ---");
        while (temp != null) {
            System.out.println(temp.visit);
            temp = temp.next;
        }
    }
}