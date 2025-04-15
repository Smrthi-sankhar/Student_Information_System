package entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Sis {
	public Sis() {
        // Initialize lists, DB connection, or setup configs if any
        System.out.println("Student Information System initialized.");
    }
	 // Add Enrollment method
	public void addPayment(Student student, double amount, Date utilDate) {
	    LocalDate paymentDate = utilDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
	    int studentId = student.getStudentId();
	    Payment payment = new Payment(0, studentId, amount, paymentDate, student);
	    student.getPayments().add(payment); // use plural getter
	}

	
	 // Assign Course to Teacher method
    public void assignCourseToTeacher(Course course, Teacher teacher) {
        teacher.getAssignedCourses().add(course);  // Add course to teacher's course list
    }
    
    // Add Payment method
    public void addPayment(Student student, double amount, LocalDate paymentDate) {
        
        int studentId = student.getStudentId(); // Assuming the Student class has a method to get studentId
        Payment payment = new Payment(0, studentId, amount, paymentDate, student);
        student.getPayments().add(payment); // Add payment to student's payment history
    }
    
	 // Get Enrollments for a Student method
	    public List<Enrollment> getEnrollmentsForStudent(Student student) {
	        return student.getEnrollments();  // Retrieve student's list of enrollments
	    }
	    
	 // Get Courses for a Teacher method
	    public List<Course> getCoursesForTeacher(Teacher teacher) {
	        return teacher.getAssignedCourses();  // Retrieve teacher's list of assigned courses
	    }

}
