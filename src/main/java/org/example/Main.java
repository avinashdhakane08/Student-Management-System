package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int choice;

        StudentService service = new StudentService();
        do {
            System.out.println();
            System.out.println("---------- Student Management System----------");

            System.out.println("1. Add Student");
            System.out.println("2. View All Student");
            System.out.println("3. Search Student");
            System.out.println("4. Update student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.println("Enter your choice");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:


                    System.out.println("Enter student name:");
                    String name = sc.nextLine();
                    sc.nextLine();

                    if (name.isBlank()) {
                        System.out.println("Name cannot be empty");
                    }

                    System.out.println("Enter student email:");
                    String email = sc.nextLine();
                    sc.nextLine();

                    if (email.isBlank()) {
                        System.out.println("Email cannot be empty.");
                        break;
                    }

                    System.out.println("Enter course name:");
                    String course = sc.nextLine();
                    sc.nextLine();

                    System.out.println("Enter marks:");
                    double mark = sc.nextDouble();

                    Student newStudent = new Student( name, email, course, mark);
                    service.addStudent(newStudent);
                    break;

                case 2:
                    service.viewAllStudents();
                    break;

                case 3:
                    System.out.println("Enter student Id: ");
                    int newId = sc.nextInt();
                    sc.nextLine();
                    service.searchStudent(newId);
                    break;

                case 4:

                    System.out.println("Enter the ID where you want to update:");
                    int Id= sc.nextInt();
                    sc.nextLine();


                    System.out.println("Enter student name:");
                    String newName = sc.nextLine();

                    System.out.println("Enter student email:");
                    String newEmail = sc.nextLine();


                    System.out.println("Enter course name:");
                    String newCourse = sc.nextLine();


                    System.out.println("Enter marks:");
                    double newMark = sc.nextDouble();

                    Student student = new Student( );

                    student.setId(Id);
                    student.setName(newName);
                    student.setEmail(newEmail);
                    student.setCourse(newCourse);
                    student.setMarks(newMark);

                    service.updateStudentDetails(student);
                    break;

                case 5:
                    System.out.println("Enter student Id: ");
                    int sId = sc.nextInt();
                    sc.nextLine();
                    service.deleteStudent(sId);
                    break;


                case 6:
                    System.out.println("Application closed.");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 6);
        {
            sc.close();
        }
    }
}
