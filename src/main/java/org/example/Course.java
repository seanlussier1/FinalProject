package org.example;

import java.util.ArrayList;


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
        double totalWeight = 0;
        for (Assignment assignment : assignments) {
            totalWeight += assignment.getWeight();
        }
        return totalWeight == 1.0;
    }

    // adds a student to the student list of the course,
    // also add a new null element to each assignment of this course,
    // and add a new null element for the finalScores.
    boolean registerStudent(Student student) {
        registeredStudents.add(student);
        assignments.add(null);
        finalScores.add(null);
        return true;
    }
    // calculates the weighted average score of a student.
    int[] calcStudentsAverage() {
        Assignment assignment = new Assignment()
    }

    /**
     * adds a new assignment to the course
     * @param assignmentName the input assignment name
     * @param weight the input assignment weight
     * @param maxScore the input max score
     * @return true after adding the assignment to assignments
     */
    boolean addAssignment(String assignmentName, double weight, int maxScore) {
        Assignment assignment = new Assignment(assignmentName, weight, maxScore);
        assignments.add(assignment);
        return true;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

    public ArrayList<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(ArrayList<Student> registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

    public ArrayList<Double> getFinalScores() {
        return finalScores;
    }

    public void setFinalScores(ArrayList<Double> finalScores) {
        this.finalScores = finalScores;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Course.nextId = nextId;
    }
}
