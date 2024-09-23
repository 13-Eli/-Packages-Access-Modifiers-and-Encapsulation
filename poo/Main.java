package org.generation.poo;

import org.generation.poo.courses.CourseNotFoundException;
import org.generation.poo.students.Student;
import org.generation.poo.students.StudentNotFoundException;
import org.generation.poo.students.StudentService;

public class Main {

    public static void main(String[] args) {
        StudentService studentService = new StudentService();

        // Agregar estudiantes usando el método de servicio
        studentService.addStudent(new Student("Carlos", "1030", 31));
        studentService.addStudent(new Student("Ian", "1020", 28));
        studentService.addStudent(new Student("Elise", "1050", 26));
        studentService.addStudent(new Student("Santiago", "1020", 33));

        try {
            // Inscribir estudiantes en cursos
            studentService.enrollStudents("Math", "1030");
        } catch (CourseNotFoundException | StudentNotFoundException e) {
            e.printStackTrace();
        }

        // Mostrar todos los cursos
        studentService.showAllCourses();

        // Mostrar estudiantes inscritos en un curso
        studentService.showEnrolledStudents("Math");
    }
}
