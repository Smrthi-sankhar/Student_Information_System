package dao;

import entity.Course;
import entity.Enrollment;
import entity.Teacher;

import java.util.List;

public interface CourseDao {
    void assignTeacher(Course course, Teacher teacher);
    void updateCourseInfo(Course course, String code, String name, String instructor);
    void displayCourseInfo(Course course);
    List<Enrollment> getEnrollments(Course course);
    Teacher getTeacher(Course course);
}
