package org.generation.poo.students;

import org.generation.poo.courses.Course;
import org.generation.poo.courses.CourseNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {
    private final Map<String, Course> courseList = new HashMap<>();
    private final Map<String, Student> students = new HashMap<>();
    private final Map<String, List<Course>> coursesEnrolledByStudents = new HashMap<>();

    public StudentService() {
        courseList.put("Math", new Course("Math", 10, "Aurelio Baldor"));
        courseList.put("Physics", new Course("Physics", 10, "Albert Einstein"));
        courseList.put("Art", new Course("Art", 10, "Pablo Picasso"));
        courseList.put("History", new Course("History", 10, "Sima Qian"));
        courseList.put("Biology", new Course("Biology", 10, "Charles Darwin"));
    }

    public void enrollStudents(String courseName, String studentID) throws CourseNotFoundException, StudentNotFoundException {
        Course course = courseList.get(courseName);
        if (course == null) {
            throw new CourseNotFoundException();
        }
        Student student = students.get(studentID);
        if (student == null) {
            throw new StudentNotFoundException();
        }
        if (!coursesEnrolledByStudents.containsKey(studentID)) {
            coursesEnrolledByStudents.put(studentID, new ArrayList<>());
        }
        coursesEnrolledByStudents.get(studentID).add(course);
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void showEnrolledStudents(String courseId) {
        for (Map.Entry<String, List<Course>> entry : coursesEnrolledByStudents.entrySet()) {
            List<Course> courses = entry.getValue();
            for (Course course : courses) {
                if (course.getName().equals(courseId)) {
                    System.out.println("Student ID: " + entry.getKey());
                }
            }
        }
    }

    public void showAllCourses() {
        for (Course course : courseList.values()) {
            System.out.println("Course: " + course.getName() + ", Credits: " + course.getCredits() + ", Professor: " + course.getProfessorName());
        }
    }
}
