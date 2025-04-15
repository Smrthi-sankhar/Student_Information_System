package main;

import dao.SisService;
import dao.SisImpl;
import entity.Course;
import entity.Student;
import entity.Teacher;
import exception.DuplicateEnrollmentException;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class MainModule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SisService sis = new SisImpl(); // Service implementation

        String continueChoice;
        do {
            System.out.println("\n--- Welcome to the Student Information System ---");
            System.out.println("1. Create student and Enroll Student in Course");
            System.out.println("2. Add Course");
            System.out.println("3. Add Teacher");
            System.out.println("4. Assign Teacher to Course");
            System.out.println("5. Record Payment by Student");
            System.out.println("6. Generate Enrollment Report");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Clear buffer

            try {
                switch (choice) {
                    case 1:
                        // Task: Enroll Student in Course
                        System.out.print("Enter Student First Name: ");
                        String firstName = sc.nextLine();
                        System.out.print("Enter Student Last Name: ");
                        String lastName = sc.nextLine();
                        System.out.print("Enter Student Date of Birth (yyyy-mm-dd): ");
                        LocalDate dob = LocalDate.parse(sc.nextLine());
                        System.out.print("Enter Student Email: ");
                        String email = sc.nextLine();
                        System.out.print("Enter Student Phone Number: ");
                        String phone = sc.nextLine();

                        Student student = new Student();
                        student.setFirstName(firstName);
                        student.setLastName(lastName);
                        student.setDateOfBirth(dob);
                        student.setEmail(email);
                        student.setPhoneNumber(phone);

                        // Task: Create Courses
                        System.out.print("Enter Course ID to Enroll in: ");
                        int courseId = sc.nextInt();
                        sc.nextLine(); // Clear buffer
                        Course course = new Course();
                        course.setCourseId(courseId);  // Course ID should match DB

                        try {
                            sis.enrollStudentInCourse(student, course);
                            System.out.println("done!! " + firstName + " " + lastName + " enrolled in course " + courseId);
                        } catch (DuplicateEnrollmentException e) {
                            System.out.println("⚠️ " + e.getMessage());
                        }
                        break;
                        

                    case 2:
                        // Add Course
                        System.out.print("Enter Course Name: ");
                        String cName = sc.nextLine();
                        System.out.print("Enter Course Code: ");
                        String cCode = sc.nextLine();

                        Course newCourse = new Course();
                        newCourse.setCourseName(cName);
                        newCourse.setCourseCode(cCode);

                        sis.addCourse(newCourse);
                        System.out.println(" Course added successfully.");
                        break;
                        
                    case 3:
                        // Add Teacher
                        System.out.print("Enter Teacher First Name: ");
                        String tFirst = sc.nextLine();
                        System.out.print("Enter Teacher Last Name: ");
                        String tLast = sc.nextLine();
                        System.out.print("Enter Email: ");
                        String tEmail = sc.nextLine();

                        Teacher newTeacher = new Teacher();
                        newTeacher.setFirstName(tFirst);
                        newTeacher.setLastName(tLast);
                        newTeacher.setEmail(tEmail);

                        sis.addTeacher(newTeacher);
                        System.out.println(" Teacher added successfully.");
                        break;

                    case 4:
                        // Task: Assign Teacher to Course
                        System.out.print("Enter Teacher First Name: ");
                        String teacherFirstName = sc.nextLine();
                        System.out.print("Enter Teacher Last Name: ");
                        String teacherLastName = sc.nextLine();
                        

                        // Create Teacher Object
                        Teacher teacher = new Teacher();
                        teacher.setFirstName(teacherFirstName);
                        teacher.setLastName(teacherLastName);
                        

                        System.out.print("Enter Course Code to Assign Teacher: ");
                        String courseCode = sc.nextLine();

                        Course assignCourse = new Course();
                        assignCourse.setCourseCode(courseCode);

                        sis.assignTeacherToCourse(teacher, assignCourse);
                        System.out.println("yeah!! " + teacherFirstName + " " + teacherLastName + " assigned to course " + courseCode);
                        break;

                    case 5:
                        // Task: Record Payment by Student
                        System.out.print("Enter Student ID: ");
                        int studentId = sc.nextInt();
                        sc.nextLine(); // Clear buffer
                        System.out.print("Enter Payment Amount: ");
                        double amount = sc.nextDouble();
                        sc.nextLine(); // Clear buffer
                        System.out.print("Enter Payment Date (yyyy-mm-dd): ");
                        Date paymentDate = Date.valueOf(sc.nextLine());

                        Student payingStudent = new Student();
                        payingStudent.setStudentId(studentId);
                        sis.recordPayment(payingStudent, amount, paymentDate);
                        System.out.println(" Payment of ₹" + amount + " recorded for student ID " + studentId + " on " + paymentDate);
                        break;

                    case 6:
                        // Task: Generate Enrollment Report
          
                        System.out.print("Enter Course ID for Report: ");
                        int reportCourseId = Integer.parseInt(sc.nextLine());
                        Course reportCourse = new Course();
                        reportCourse.setCourseId(reportCourseId);
                        sis.generateEnrollmentReport(reportCourse);

                        break;


                    case 7:
                        // Exit
                        System.out.println("Exiting... Goodbye!");
                        return;

                    default:
                        System.out.println("⚠️ Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Unexpected Error: " + e.getMessage());
                e.printStackTrace();
            }

            // Continue or exit loop
            System.out.print("Do you want to continue (yes/no)? ");
            continueChoice = sc.nextLine();

        } while (continueChoice.equalsIgnoreCase("yes"));

        sc.close();
        System.out.println("Byebye............");
    }
}



