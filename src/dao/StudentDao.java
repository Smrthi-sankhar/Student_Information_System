package dao;

import entity.Course;
import entity.Payment;
import entity.Student;

import java.util.Date;
import java.util.List;

public interface StudentDao {
    void enrollInCourse(Student student, Course course);
    void updateStudentInfo(Student student, String firstName, String lastName, Date dob, String email, String phone);
    void makePayment(Student student, double amount, Date paymentDate);
    void displayStudentInfo(Student student);
    List<Course> getEnrolledCourses(Student student);
    List<Payment> getPaymentHistory(Student student);
}

