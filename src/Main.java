import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PatientBST bst = new PatientBST();
        EmergencyQueue queue = new EmergencyQueue();
        TreatmentStack stack = new TreatmentStack();
        PatientVisitLinkedList visitList = new PatientVisitLinkedList();

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Patient (BST)");
            System.out.println("2. Search Patient (BST)");
            System.out.println("3. Delete Patient (BST)");
            System.out.println("4. Display All Patients In-Order (BST)");
            System.out.println("5. Enqueue Emergency Patient (Queue)");
            System.out.println("6. Dequeue & Treat Patient (Queue)");
            System.out.println("7. Display Waiting Queue (Queue)");
            System.out.println("8. Add Completed Treatment (Stack)");
            System.out.println("9. Pop Latest Treatment (Stack)");
            System.out.println("10. Display Treatment History (Stack)");
            System.out.println("11. Add Patient Visit History (Linked List)");
            System.out.println("12. Display Visit History (Linked List)");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Age: "); int age = sc.nextInt(); sc.nextLine();
                    System.out.print("Contact: "); String contact = sc.nextLine();
                    System.out.print("Condition: "); String cond = sc.nextLine();
                    bst.insert(new Patient(id, name, age, contact, cond));
                    System.out.println("Patient Added Successfully!");
                    break;
                case 2:
                    System.out.print("Enter ID to search: ");
                    Patient p = bst.search(sc.nextInt());
                    System.out.println(p != null ? p : "Patient Not Found!");
                    break;
                case 3:
                    System.out.print("Enter ID to delete: ");
                    bst.delete(sc.nextInt());
                    System.out.println("Patient Deleted!");
                    break;
                case 4:
                    System.out.println("--- Patient List (Ascending Order) ---");
                    bst.inOrder();
                    break;
                case 5:
                    System.out.print("Enter Patient ID to Enqueue: ");
                    Patient eqP = bst.search(sc.nextInt());
                    if (eqP != null) {
                        queue.enqueue(eqP);
                        System.out.println("Added to Emergency Queue!");
                    } else System.out.println("Patient ID does not exist in BST!");
                    break;
                case 6:
                    Patient dequeuedP = queue.dequeue();
                    if (dequeuedP != null) System.out.println("Treating Patient: " + dequeuedP.getName());
                    break;
                case 7:
                    queue.display();
                    break;
                case 8:
                    System.out.print("Patient ID: "); int tId = sc.nextInt(); sc.nextLine();
                    System.out.print("Name: "); String tName = sc.nextLine();
                    System.out.print("Treatment: "); String treat = sc.nextLine();
                    System.out.print("Time: "); String time = sc.nextLine();
                    stack.push(new TreatmentRecord(tId, tName, treat, time));
                    System.out.println("Record Saved to Stack!");
                    break;
                case 9:
                    TreatmentRecord popped = stack.pop();
                    if (popped != null) System.out.println("Popped: " + popped);
                    break;
                case 10:
                    stack.display();
                    break;
                case 11:
                    System.out.print("Visit ID: "); int vId = sc.nextInt(); sc.nextLine();
                    System.out.print("Date: "); String date = sc.nextLine();
                    System.out.print("Doctor: "); String doc = sc.nextLine();
                    System.out.print("Diagnosis: "); String diag = sc.nextLine();
                    System.out.print("Treatment: "); String vTreat = sc.nextLine();
                    visitList.addVisit(new Visit(vId, date, doc, diag, vTreat));
                    System.out.println("Visit Added!");
                    break;
                case 12:
                    visitList.displayVisits();
                    break;
                case 0:
                    System.out.println("Exiting System...");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 0);

        sc.close();
    }
}