package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Getter
@Setter

public class Course {
    private String courseId; // C-departmentId-twoDigitCourseId, e.g.: C-D01-01
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;
    private ArrayList<Double> finalScores;
    private static int nextId; // indicates the next ID that will be used

    /**
     * checks if the sum of weights of all assignments of that course equals to 1 (100%)
     * @return true if the weights of all assignments = 1 and false if the weights are anything else
     */
    boolean isAssignmentWeightValid() {
        assignments.get(1).
    }

    // adds a student to the student list of the course,
    // also add a new null element to each assignment of this course,
    // and add a new null element for the finalScores.
    boolean registerStudent(Student student) {
        registeredStudents.add(student);
    }
}
