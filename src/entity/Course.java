package entity;

import java.util.List;

public class Course {
    private int courseId;
    private String courseName;
    private String courseCode;
    private String instructorName;
    
    //collection relationship
    private List<Enrollment> enrollment;
    
    //getter for this
    public List<Enrollment> getEnrollments() {
        return enrollment;
    }
    

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Course(int courseId, String courseName, String courseCode, String instructorName) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.instructorName = instructorName;
	}


	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getCourseCode() {
		return courseCode;
	}


	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}


	public String getInstructorName() {
		return instructorName;
	}


	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}


	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseCode=" + courseCode
				+ ", instructorName=" + instructorName + "]";
	}

}