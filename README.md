# Mini Hospital Emergency Management System

A Java-based console application designed to simulate a hospital emergency management workflow using core Data Structures. Developed as part of the **CIT300 - Data Structures and Algorithms** module assignment at Sri Lanka Technology Campus (SLTC).

---

## 📌 Project Overview
The system simulates real-world emergency hospital operations including patient registration, priority emergency queuing, treatment history tracking, and patient visit logs using custom Data Structure implementations.

---

## 🛠️ Implemented Data Structures & Features

### 1. Patient Records — Binary Search Tree (BST)
- **Key:** Patient ID
- **Features:** Insert new patient, Search patient by ID, Delete patient record, In-order traversal (displays patients in ascending order of ID).
- **Data:** Patient ID, Name, Age, Contact Number, Medical Condition.

### 2. Emergency Patient Queue — Queue (FIFO)
- **Principle:** First-In, First-Out
- **Features:** Enqueue (add waiting emergency patient), Dequeue (remove patient for treatment), Display waiting queue, Empty queue handling.

### 3. Treatment History — Stack (LIFO)
- **Principle:** Last-In, First-Out
- **Features:** Push (record completed treatment), Pop (remove most recent treatment record), Display treatment history, Empty stack handling.

### 4. Patient Visit History — Singly Linked List
- **Features:** Add new visit record, Remove visit, Search visit details, Display complete visit history.
- **Data:** Visit ID, Date, Doctor Name, Diagnosis, Treatment.

---

## 📁 Repository Structure

```text
src/
├── Patient.java                  # Model class for Patient details
├── PatientBST.java               # Binary Search Tree implementation
├── EmergencyQueue.java           # Queue implementation for Emergency unit
├── TreatmentRecord.java          # Model class for completed treatments
├── TreatmentStack.java           # Stack implementation for treatment logs
├── Visit.java                    # Model class for visit records
├── PatientVisitLinkedList.java   # Singly Linked List for visit history
└── Main.java                     # Interactive CLI Application & Menu