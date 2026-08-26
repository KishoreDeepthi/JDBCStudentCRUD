package com.jdbcstudent;

import java.util.List;
import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {

	        Scanner scanner = new Scanner(System.in);
	        StudentDAO dao = new StudentDAO();

	        while (true) {

	            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
	            System.out.println("1. Add Student");
	            System.out.println("2. View Students");
	            System.out.println("3. Update Student");
	            System.out.println("4. Delete Student");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = scanner.nextInt();
	            scanner.nextLine();

	            switch (choice) {

	                case 1:
	                    System.out.print("Enter name: ");
	                    String name = scanner.nextLine();

	                    System.out.print("Enter email: ");
	                    String email = scanner.nextLine();

	                    System.out.print("Enter course: ");
	                    String course = scanner.nextLine();

	                    Student student = new Student(name, email, course);
	                    dao.addStudent(student);
	                    break;

	                case 2:
	                    List<Student> students = dao.getAllStudents();

	                    if (students.isEmpty()) {
	                        System.out.println("No students found.");
	                    } else {
	                        System.out.println("\n----- STUDENTS -----");

	                        for (Student s : students) {
	                            System.out.println(s);
	                        }
	                    }
	                    break;

	                case 3:
	                    System.out.print("Enter student ID: ");
	                    int updateId = scanner.nextInt();
	                    scanner.nextLine();

	                    System.out.print("Enter new name: ");
	                    String newName = scanner.nextLine();

	                    System.out.print("Enter new email: ");
	                    String newEmail = scanner.nextLine();

	                    System.out.print("Enter new course: ");
	                    String newCourse = scanner.nextLine();

	                    Student updatedStudent =
	                            new Student(updateId, newName, newEmail, newCourse);

	                    dao.updateStudent(updatedStudent);
	                    break;

	                case 4:
	                    System.out.print("Enter student ID to delete: ");
	                    int deleteId = scanner.nextInt();
	                    scanner.nextLine();

	                    dao.deleteStudent(deleteId);
	                    break;

	                case 5:
	                    System.out.println("Thank you for using Student Management System!");
	                    scanner.close();
	                    return;

	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }
}
