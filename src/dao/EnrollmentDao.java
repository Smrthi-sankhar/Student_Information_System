package dao;

import entity.Course;
import entity.Enrollment;
import entity.Student;

public interface EnrollmentDao {
    Student getStudent(Enrollment enrollment);
    Course getCourse(Enrollment enrollment);
}
