package controller;

import model.Student;
import view.StudentView;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {

    private ArrayList<Student> students;
    private StudentView view;

    public StudentController() {
        students = new ArrayList<>();
        view = new StudentView();
    }

    public void start() {

        Scanner sc = new Scanner(System.in);

        while(true) {

            view.displayMenu();

            int choice = sc.nextInt();

            switch(choice) {

                case 1:
                    addStudent(sc);
                    break;

                case 2:
                    view.displayAllStudents(students);
                    break;

                case 3:
                    updateStudent(sc);
                    break;

                case 4:
                    deleteStudent(sc);
                    break;

                case 5:
                    searchStudent(sc);
                    break;

                case 6:
                    view.showMessage("Exiting Program...");
                    return;

                default:
                    view.showMessage("Invalid Choice!");
            }
        }
    }

    private void addStudent(Scanner sc) {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        Student s = new Student(id, name, age, dept);

        students.add(s);

        view.showMessage("Student Added Successfully!");
    }

    private void updateStudent(Scanner sc) {

        System.out.print("Enter Student ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for(Student s : students) {

            if(s.getId() == id) {

                System.out.print("Enter New Name: ");
                s.setName(sc.nextLine());

                System.out.print("Enter New Age: ");
                s.setAge(sc.nextInt());
                sc.nextLine();

                System.out.print("Enter New Department: ");
                s.setDepartment(sc.nextLine());

                view.showMessage("Student Updated Successfully!");
                return;
            }
        }

        view.showMessage("Student Not Found!");
    }

    private void deleteStudent(Scanner sc) {

        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();

        for(Student s : students) {

            if(s.getId() == id) {

                students.remove(s);

                view.showMessage("Student Deleted Successfully!");
                return;
            }
        }

        view.showMessage("Student Not Found!");
    }

    private void searchStudent(Scanner sc) {

        System.out.print("Enter Student ID to Search: ");
        int id = sc.nextInt();

        for(Student s : students) {

            if(s.getId() == id) {

                view.displayStudent(s);
                return;
            }
        }

        view.showMessage("Student Not Found!");
    }
}