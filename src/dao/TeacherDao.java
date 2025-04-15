package dao;

import entity.Course;
import entity.Teacher;

import java.util.List;

public interface TeacherDao {
    void updateTeacherInfo(Teacher teacher, String name, String email, String expertise);
    void displayTeacherInfo(Teacher teacher);
    List<Course> getAssignedCourses(Teacher teacher);
}

