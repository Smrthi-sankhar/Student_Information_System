package entity;
import java.time.LocalDate;

public class Enrollment {
	private int enrollmentId;
    private int studentId;     // Reference to Student object
    private int courseId;       // Reference to Course object
    private LocalDate enrollmentDate;
    
    //collection relationship
    private Student student;
    private Course course;
    
    //getter for this
    
    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }
    
    //default constructor
	public Enrollment() {
		super();
	}

	public Enrollment(int enrollmentId, int studentId, int courseId, LocalDate enrollmentDate, Student student, Course course) {
		super();
		this.enrollmentId = enrollmentId;
		this.studentId = studentId;
		this.courseId = courseId;
		this.enrollmentDate = enrollmentDate;
		this.student = student;  // setting the student for this enrollment
        this.course = course;  // setting the course for this enrollment
	}

	public int getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	@Override
	public String toString() {
		return "Enrollment [enrollmentId=" + enrollmentId + ", studentId=" + studentId + ", courseId=" + courseId
				+ ", enrollmentDate=" + enrollmentDate + "]";
	}
}
