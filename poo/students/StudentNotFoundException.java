package org.generation.poo.students;

public class StudentNotFoundException extends Exception {
    public StudentNotFoundException() {
        super("Student not found!");
    }
}
