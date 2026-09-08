class BSTNode {
    Patient patient;
    BSTNode left, right;

    public BSTNode(Patient patient) {
        this.patient = patient;
        this.left = this.right = null;
    }
}

public class PatientBST {
    private BSTNode root;

    public void insert(Patient patient) {
        root = insertRec(root, patient);
    }

    private BSTNode insertRec(BSTNode root, Patient patient) {
        if (root == null) {
            root = new BSTNode(patient);
            return root;
        }
        if (patient.getPatientId() < root.patient.getPatientId())
            root.left = insertRec(root.left, patient);
        else if (patient.getPatientId() > root.patient.getPatientId())
            root.right = insertRec(root.right, patient);
        return root;
    }

    public Patient search(int patientId) {
        return searchRec(root, patientId);
    }

    private Patient searchRec(BSTNode root, int patientId) {
        if (root == null || root.patient.getPatientId() == patientId)
            return (root != null) ? root.patient : null;
        if (patientId < root.patient.getPatientId())
            return searchRec(root.left, patientId);
        return searchRec(root.right, patientId);
    }

    public void delete(int patientId) {
        root = deleteRec(root, patientId);
    }

    private BSTNode deleteRec(BSTNode root, int patientId) {
        if (root == null) return root;

        if (patientId < root.patient.getPatientId())
            root.left = deleteRec(root.left, patientId);
        else if (patientId > root.patient.getPatientId())
            root.right = deleteRec(root.right, patientId);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            root.patient = minValue(root.right);
            root.right = deleteRec(root.right, root.patient.getPatientId());
        }
        return root;
    }

    private Patient minValue(BSTNode root) {
        Patient minv = root.patient;
        while (root.left != null) {
            minv = root.left.patient;
            root = root.left;
        }
        return minv;
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(BSTNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.patient);
            inOrderRec(root.right);
        }
    }
}