package code;

import java.util.List;
import java.util.Scanner;

import Student_service.Studentservice;
import student_Certificate.Certificate;
import student_Certificate.CertificateService;

public class Student_main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Studentservice studentService = new Studentservice();
        CertificateService certificateService = new CertificateService();

        while (true) {
            System.out.println("\n--- Student Management Console ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Student by ID");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. View All Students");
            System.out.println("6. Add Certificate to Student");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    Student student = new Student();
                    System.out.print("Enter name: ");
                    student.setStud_name(scanner.nextLine());
                    System.out.print("Enter father's name: ");
                    student.setFathername(scanner.nextLine());
                    System.out.print("Enter phone: ");
                    student.setPhone(scanner.nextLine());
                    System.out.print("Enter college: ");
                    student.setCollege(scanner.nextLine());

                    studentService.saveStudent(student);
                    System.out.println("✅ Student saved!");
                    break;

                case 2:
                    System.out.print("Enter student ID: ");
                    long viewId = scanner.nextLong();
                    Student found = studentService.getbyid(viewId);
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("❌ Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID to update: ");
                    long updateId = scanner.nextLong();
                    scanner.nextLine();
                    Student updatedData = new Student();
                    System.out.print("Enter new name: ");
                    updatedData.setStud_name(scanner.nextLine());
                    System.out.print("Enter new father's name: ");
                    updatedData.setFathername(scanner.nextLine());
                    Student updated = studentService.updateStudent(updateId, updatedData);
                    if (updated != null) {
                        System.out.println("✅ Student updated.");
                    } else {
                        System.out.println("❌ Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter student ID to delete: ");
                    long deleteId = scanner.nextLong();
                    studentService.deleteStudent(deleteId);
                    System.out.println("✅ Student deleted.");
                    break;

                case 5:
                    List<Student> allStudents = studentService.getAllStudents();
                    for (Student s : allStudents) {
                        System.out.println(s);
                    }
                    break;

                case 6:
                    System.out.print("Enter student ID to add certificate: ");
                    long sid = scanner.nextLong();
                    scanner.nextLine();
                    Student st = studentService.getbyid(sid);
                    if (st == null) {
                        System.out.println("❌ Student not found.");
                        break;
                    }

                    Certificate cert = new Certificate();
                    System.out.print("Enter certificate title: ");
                    cert.setTitle(scanner.nextLine());
                    System.out.print("Enter certificate about: ");
                    cert.setAbout(scanner.nextLine());
                    System.out.print("Enter certificate link: ");
                    cert.setLink(scanner.nextLine());
                    cert.setStudent(st);

                    certificateService.saveCertificate(cert);
                    System.out.println("✅ Certificate added.");
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}
