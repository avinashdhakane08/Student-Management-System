package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        int choice;

        do {
            System.out.println();
            System.out.println("---------- Student Management System ----------");

            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    if (name.isBlank()) {
                        System.out.println("Name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter student email: ");
                    String email = sc.nextLine();

                    if (email.isBlank()) {
                        System.out.println("Email cannot be empty.");
                        break;
                    }

                    System.out.print("Enter course name: ");
                    String course = sc.nextLine();

                    if (course.isBlank()) {
                        System.out.println("Course cannot be empty.");
                        break;
                    }

                    System.out.print("Enter marks: ");
                    double mark = sc.nextDouble();
                    sc.nextLine();

                    if (mark < 0 || mark > 100) {
                        System.out.println("Marks must be between 0 and 100.");
                        break;
                    }

                    Student newStudent =
                            new Student(name, email, course, mark);

                    service.addStudent(newStudent);
                    break;

                case 2:

                    service.viewAllStudents();
                    break;

                case 3:

                    System.out.print("Enter student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    service.searchStudent(id);
                    break;

                case 4:

                    System.out.print("Enter the ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter student name: ");
                    String newName = sc.nextLine();

                    if (newName.isBlank()) {
                        System.out.println("Name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter student email: ");
                    String newEmail = sc.nextLine();

                    if (newEmail.isBlank()) {
                        System.out.println("Email cannot be empty.");
                        break;
                    }

                    System.out.print("Enter course name: ");
                    String newCourse = sc.nextLine();

                    if (newCourse.isBlank()) {
                        System.out.println("Course cannot be empty.");
                        break;
                    }

                    System.out.print("Enter marks: ");
                    double newMark = sc.nextDouble();
                    sc.nextLine();

                    if (newMark < 0 || newMark > 100) {
                        System.out.println("Marks must be between 0 and 100.");
                        break;
                    }

                    Student student = new Student();

                    student.setId(updateId);
                    student.setName(newName);
                    student.setEmail(newEmail);
                    student.setCourse(newCourse);
                    student.setMark(newMark);

                    service.updateStudentDetails(student);
                    break;

                case 5:

                    System.out.print("Enter student ID: ");
                    int studentId = sc.nextInt();
                    sc.nextLine();

                    service.deleteStudent(studentId);
                    break;

                case 6:

                    System.out.println("Application closed.");
                    break;

                default:

                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}