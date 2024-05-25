package org.example;

import java.util.ArrayList;

public class Student {
    private String studentId; // 6-digits starts with a character S
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId; // indicates the next ID that will be used

    // registers a course, this method (1) adds the course to the student's registeredCourses list,
    // (2) adds the student to the course's registeredStudents list,
    // (3) appends a null for the scores of each assignment of the course.
    // If the course is already registered, directly returns false
    boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }
        registeredCourses.add(course);
        course.
    }
    // drops a course, remove the course from the student's registeredCourses list,
    // and remove the student from the course's registeredStudents list. If the course is not registered yet,
    // directly returns false
    boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            return false;
        }
        registeredCourses.remove(course);

    }
}
