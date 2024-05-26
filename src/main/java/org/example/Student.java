package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@EqualsAndHashCode

public class Student {
    private String studentId; // 6-digits starts with a character S
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId = 1; // indicates the next ID that will be used

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.studentId = "S" + String.format("%05d", nextId++);
        this.registeredCourses = new ArrayList<>();
    }

    // registers a course, this method (1) adds the course to the student's registeredCourses list,
    // (2) adds the student to the course's registeredStudents list,
    // (3) appends a null for the scores of each assignment of the course.
    // If the course is already registered, directly returns false
    boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }
        registeredCourses.add(course);
        course.registerStudent(this);
        return true;
    }

    // drops a course, remove the course from the student's registeredCourses list,
    // and remove the student from the course's registeredStudents list. If the course is not registered yet,
    // directly returns false
    boolean dropCourse(Course course) {
        if (!registeredCourses.contains(this)) {
            return false;
        }
        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);
        return true;
    }
    // converts a student to a simple string with only the studentId, the studentName, and departmentName.
    // This method is called in Course toString().
    public String toSimplifiedString() {
        return "Student{" +
                "studentId =' \n" + studentId + '\'' +
                ", studentName ='\n" + studentName + '\'' +
                ", departmentName =" + department.getDepartmentName() +
                '}';

    }
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", department=" + department +
                ", registeredCourses=" + registeredCourses. +
                '}';
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public ArrayList<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(ArrayList<Course> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Student.nextId = nextId;
    }
}
