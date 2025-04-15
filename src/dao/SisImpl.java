package dao;

import entity.*;
import exception.DuplicateEnrollmentException;
import util.DBConnUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.Date;

public class SisImpl implements SisService {

    @Override
    public void enrollStudentInCourse(Student student, Course course) throws DuplicateEnrollmentException {
        try (Connection con = DBConnUtil.getDbConnection()) {
            // 1. Insert student
            String insertStudent = "INSERT INTO student (first_name, last_name, dob, email, phone) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(insertStudent, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, student.getFirstName());
                ps.setString(2, student.getLastName());
                ps.setDate(3, java.sql.Date.valueOf(student.getDateOfBirth()));
                ps.setString(4, student.getEmail());
                ps.setString(5, student.getPhoneNumber());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    student.setStudentId(rs.getInt(1));
                }
            }

            // 2. Check and insert enrollment
            String checkEnrollment = "SELECT * FROM enrollment WHERE student_id = ? AND course_id = ?";
            String insertEnrollment = "INSERT INTO enrollment (student_id, course_id, enrollment_date) VALUES (?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(checkEnrollment)) {
                ps.setInt(1, student.getStudentId());
                ps.setInt(2, course.getCourseId());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) throw new DuplicateEnrollmentException("Student already enrolled in this course.");
            }
            try (PreparedStatement ps = con.prepareStatement(insertEnrollment)) {
                ps.setInt(1, student.getStudentId());
                ps.setInt(2, course.getCourseId());
                ps.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void addCourse(Course course) {
        try (Connection con = DBConnUtil.getDbConnection()) {
            String insertCourse = "INSERT INTO course (course_code, course_name,instructor_name  ) VALUES (?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(insertCourse)) {
                ps.setString(1, course.getCourseCode());
                ps.setString(2, course.getCourseName());
                ps.setString(3, course.getInstructorName());
                ps.executeUpdate();
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void addTeacher(Teacher teacher) {
        try (Connection con = DBConnUtil.getDbConnection()) {
            String insertTeacher = "INSERT INTO teacher (first_name, last_name, email) VALUES (?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(insertTeacher)) {
                ps.setString(1, teacher.getFirstName());
                ps.setString(2, teacher.getLastName());
                ps.setString(3, teacher.getEmail());
                ps.executeUpdate();
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void assignTeacherToCourse(Teacher teacher, Course course) {
        try (Connection con = DBConnUtil.getDbConnection()) {
            String updateCourse = "UPDATE course SET instructor_name = ? WHERE course_code = ?";
            try (PreparedStatement ps = con.prepareStatement(updateCourse)) {
                ps.setString(1, teacher.getFirstName() + " " + teacher.getLastName());
                ps.setString(2, course.getCourseCode());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void recordPayment(Student student, double amount, Date paymentDate) {
        try (Connection con = DBConnUtil.getDbConnection()) {
            String insertPayment = "INSERT INTO payment (student_id, amount, payment_date) VALUES (?, ?, ?)";
            
            try (PreparedStatement ps = con.prepareStatement(insertPayment)) {
                ps.setInt(1, student.getStudentId());
                ps.setDouble(2, amount);
                ps.setDate(3, new java.sql.Date(paymentDate.getTime()));
                ps.executeUpdate();
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateEnrollmentReport(Course course) {
        try (Connection con = DBConnUtil.getDbConnection()) {
            String query = "SELECT s.first_name, s.last_name FROM student s " +
                           "JOIN enrollment e ON s.student_id = e.student_id " +
                           "WHERE e.course_id = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, course.getCourseId());
                ResultSet rs = ps.executeQuery();
                System.out.println("Enrollment Report for Course ID " + course.getCourseId() + ":");
                boolean found = false;
                while (rs.next()) {
                    System.out.println("- " + rs.getString("first_name") + " " + rs.getString("last_name"));
                    found = true;
                }
                if (!found) {
                    System.out.println("No students enrolled in this course.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void generatePaymentReport(Student student) {
        // Optional based on your use-case
    }

    @Override
    public void calculateCourseStatistics(Course course) {
        // Optional based on your use-case
    }
}





	
	


