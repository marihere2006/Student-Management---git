package view;

import model.Student;
import java.util.List;

public class StudentView {

    public void displayMenu() {

        System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Search Student");
        System.out.println("6. Exit");
        System.out.print("Enter Choice: ");
    }

    public void displayStudent(Student s) {

        System.out.println("--------------------------------");
        System.out.println("ID         : " + s.getId());
        System.out.println("Name       : " + s.getName());
        System.out.println("Age        : " + s.getAge());
        System.out.println("Department : " + s.getDepartment());
    }

    public void displayAllStudents(List<Student> students) {

        if(students.isEmpty()) {
            System.out.println("No Students Found!");
            return;
        }

        for(Student s : students) {
            displayStudent(s);
        }
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }
}