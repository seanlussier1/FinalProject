package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private int maxScore;
    private double assignmentAverage;
    private ArrayList<Integer> scores;
    private static int nextId;

    /**
     * calculates the average score of one assignment
     */
    void calcAssignmentAvg() {
        double sumOfScores = 0;
        for (int score : scores) {
            sumOfScores += score;
        }
        assignmentAverage = sumOfScores / scores.size();
    }

    /**
     * generates random scores for all students in an assignment, the scores are generated with the following rule:
     * Firstly generate a random number in range [0, 10], then
     * if the number is 0, then generate a random score in range [0, 60) for the student
     * if the number is 1, 2, then generate a random score in range [60, 70) for the student
     * if the number is 3, 4, then generate a random score in range [70, 80) for the student
     * if the number is 5, 6, 7, 8, then generate a random score in range [80, 90) for the student
     * if the number is 9, 10, then generate a random score in range [90, 100] for the student
     */
    void generateRandomScore() {
        Random random = new Random();
        int randNum = random.nextInt(0, 11);
        int score;
        score = switch (randNum) {
            default -> random.nextInt(0,60);
            case 1, 2 -> random.nextInt(60, 70);
            case 3, 4 -> random.nextInt(70, 80);
            case 5, 6, 7, 8 -> random.nextInt(80, 90);
            case 9, 10 -> random.nextInt(90, 101);
        };
        scores.add(score);
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                ", maxScore=" + maxScore +
                '}';
    }
}
