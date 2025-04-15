package dao;

import entity.Course;
import entity.Student;
import entity.Teacher;
import exception.DuplicateEnrollmentException;

import java.util.Date;

public interface SisService {
    void enrollStudentInCourse(Student student, Course course) throws DuplicateEnrollmentException;
    void assignTeacherToCourse(Teacher teacher, Course course);
    void recordPayment(Student student, double amount, Date paymentDate);
    void generateEnrollmentReport(Course course);
    void generatePaymentReport(Student student);
    void calculateCourseStatistics(Course course);
    void addCourse(Course course);
    void addTeacher(Teacher teacher);

    }

    
    
    
    




