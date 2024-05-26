package org.example;

import Util.Util;
import java.util.ArrayList;

public class Course {
    private String courseId; // C-departmentId-twoDigitCourseId, e.g.: C-D01-01
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;
    private ArrayList<Double> finalScores;
    private static int nextId = 1; // indicates the next ID that will be used

    public Course(String courseId, String courseName, double credits, Department department,
                  ArrayList<Assignment> assignments, ArrayList<Student> registeredStudents,
                  ArrayList<Double> finalScores) { // constructor created for unit testing
        this.courseId = courseId;
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = assignments;
        this.registeredStudents = registeredStudents;
        this.finalScores = finalScores;
    }

    /**
     * checks if the sum of weights of all assignments of that course equals to 1 (100%)
     * @return true if the weights of all assignments = 1 and false if the weights are anything else
     */
    public boolean isAssignmentWeightValid() {
        double totalWeight = 0;
        for (Assignment assignment : assignments) {
            totalWeight += assignment.getWeight();
        }
        return totalWeight == 1.0;
    }

    /**
     * adds a student to the student list of the course,
     * also add a new null element to each assignment of this course,
     * and add a new null element for the finalScores.
     * @param student the input student
     * @return true after you register the student
     */
    public boolean registerStudent(Student student) {
        registeredStudents.add(student);
        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }
        finalScores.add(null);
        return true;
    }

    /**
     * calculates the weighted average score of a student.
     */
    public int[] calcStudentsAverage() {
        int[] averages = new int[registeredStudents.size()];

        for (int i = 0; i < registeredStudents.size(); i++) {
            double weightedSumOfScores = 0;
            for (Assignment assignment : assignments) {
                Integer tempScore = assignment.getScores().get(i);
                    weightedSumOfScores += tempScore * assignment.getWeight();
            }
            averages[i] = (int) Math.round(weightedSumOfScores);
        }
        return averages;
    }

    /**
     * adds a new assignment to the course
     * @param assignmentName the input assignment name
     * @param weight the input assignment weight
     * @param maxScore the input max score
     * @return true after adding the assignment to assignments
     */
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        Assignment assignment = new Assignment(assignmentName, weight, maxScore);
        assignments.add(assignment);
        return true;
    }

    /**
     * generates random scores for each assignment and student, and calculates the final score for each student.
     */
    public void generateScores() {
        for (Assignment assignment : assignments) {
            assignment.getScores().clear();
            for (int i = 0; i < registeredStudents.size(); i++) {
                assignment.generateRandomScore();

            }
        }
        int[] averages = calcStudentsAverage();
        for (int i = 0; i < averages.length; i++) {
            finalScores.set(i, (double) averages[i]);
        }
    }

    /**
     * displays the scores of a course in a table, with the assignment averages and student weighted average
     */
    public void displayScores() {
        generateScores();

        System.out.println("Course: " + courseName + "(C-" + department.getDepartmentId() + "-" + nextId++ + ")");
        for (Assignment assignment : assignments) {
            System.out.printf("%27s", assignment.getAssignmentName());
        }
        System.out.printf("%25s", "Final Score");
        for (int i = 0; i < registeredStudents.size(); i++) {
            Student student = registeredStudents.get(i);
            System.out.printf("\n%15s", student.getStudentName());
            for (Assignment assignment : assignments) {
                int score = assignment.getScores().get(i);
                System.out.printf("%16d", score);
            }
            System.out.printf("%35.0f\n", finalScores.get(i));
        }
        System.out.printf("%15s","Average");
        for (Assignment assignment : assignments) {
            assignment.calcAssignmentAvg();
            System.out.printf("%16.0f", assignment.getAssignmentAverage());
        }
    }

    /**
     * converts a course to a simple string with only the courseId, courseName, credits, and departmentName.
     * @return a course with only the courseId, courseName, credits, and departmentName.
     */
    public String toSimplifiedString() {
        return String.format("Course:\n" +
                "Course ID: C-%s-%s\n" +
                "Course name: %s\n" +
                "Credits: %f\n" +
                "Department: %s", department.getDepartmentId(),
                nextId++, courseName, credits, department.getDepartmentName());
    }

    @Override
    public String toString() {
        String students = "";
        for (Student student : registeredStudents) {
            students = student.toSimplifiedString();
        }
        return String.format("Course:\n" +
                "Course ID: C-%s-%s\n" +
                "Course name: %s\n" +
                "Department: %s\n" +
                "Assignment: %s" +
                "Registered students: %s", department.getDepartmentId(),
                nextId++, courseName, department, assignments, students);
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
        this.courseName = Util.toTitleCase(courseName);
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
