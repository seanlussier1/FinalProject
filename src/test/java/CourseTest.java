import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CourseTest {
    @Test
    public void testCalcStudentAvg1() {
        Department department = new Department("D01", "Computer Science");
        ArrayList<Assignment> assignments = new ArrayList<Assignment>();
        assignments.add(new Assignment("Assignment1", 0.4, 100));
        assignments.add(new Assignment("Assignment2", 0.6, 100));

        Course course = new Course("01", "Programming", 4, department,
                assignments, new ArrayList<Student>(), new ArrayList<Double>());
        Student student = new Student("Sean Lussier", Gender.MALE, new Address(123,
                "Time Square", "New York City", "New York", "A1A1A1", "USA"),
                department);
        student.registerCourse(course);
        assignments.getFirst().setScores(new ArrayList<>(List.of(88)));
        assignments.get(1).setScores(new ArrayList<>(List.of(88)));

        int[] averages = course.calcStudentsAverage();
        Assertions.assertEquals(88, averages[0]);
    }

    @Test
    public void testCalcStudentAvg2() {
        Department department = new Department("D01", "Computer Science");
        ArrayList<Assignment> assignments = new ArrayList<Assignment>();
        assignments.add(new Assignment("Assignment1", 0.4, 100));
        assignments.add(new Assignment("Assignment2", 0.6, 100));

        Course course = new Course("01", "Programming", 4, department,
                assignments, new ArrayList<Student>(), new ArrayList<Double>());
        Student student = new Student("Sean Lussier", Gender.MALE, new Address(123,
                "Time Square", "New York City", "New York", "A1A1A1", "USA"),
                department);
        student.registerCourse(course);
        assignments.getFirst().setScores(new ArrayList<>(List.of(25)));
        assignments.get(1).setScores(new ArrayList<>(List.of(88)));

        int[] averages = course.calcStudentsAverage();
        Assertions.assertEquals(63, averages[0]);
    }

    @Test
    public void testCalcStudentAvg3() {
        Department department = new Department("D01", "Computer Science");
        ArrayList<Assignment> assignments = new ArrayList<Assignment>();
        assignments.add(new Assignment("Assignment1", 0.4, 100));
        assignments.add(new Assignment("Assignment2", 0.6, 100));

        Course course = new Course("01", "Programming", 4, department,
                assignments, new ArrayList<Student>(), new ArrayList<Double>());
        Student student = new Student("Sean Lussier", Gender.MALE, new Address(123,
                "Time Square", "New York City", "New York", "A1A1A1", "USA"),
                department);
        student.registerCourse(course);
        assignments.getFirst().setScores(new ArrayList<>(List.of(88)));
        assignments.get(1).setScores(new ArrayList<>(List.of(25)));

        int[] averages = course.calcStudentsAverage();
        Assertions.assertEquals(50, averages[0]);
    }

    @Test
    public void testCalcStudentAvg4() {
        Department department = new Department("D01", "Computer Science");
        ArrayList<Assignment> assignments = new ArrayList<Assignment>();
        assignments.add(new Assignment("Assignment1", 0.4, 100));
        assignments.add(new Assignment("Assignment2", 0.6, 100));

        Course course = new Course("01", "Programming", 4, department,
                assignments, new ArrayList<Student>(), new ArrayList<Double>());
        Student student = new Student("Sean Lussier", Gender.MALE, new Address(123,
                "Time Square", "New York City", "New York", "A1A1A1", "USA"),
                department);
        student.registerCourse(course);
        assignments.getFirst().setScores(new ArrayList<>(List.of(0)));
        assignments.get(1).setScores(new ArrayList<>(List.of(25)));

        int[] averages = course.calcStudentsAverage();
        Assertions.assertEquals(15, averages[0]);
    }

    @Test
    public void testCalcStudentAvg5() {
        Department department = new Department("D01", "Computer Science");
        ArrayList<Assignment> assignments = new ArrayList<Assignment>();
        assignments.add(new Assignment("Assignment1", 0.4, 100));
        assignments.add(new Assignment("Assignment2", 0.6, 100));

        Course course = new Course("01", "Programming", 4, department,
                assignments, new ArrayList<Student>(), new ArrayList<Double>());
        Student student = new Student("Sean Lussier", Gender.MALE, new Address(123,
                "Time Square", "New York City", "New York", "A1A1A1", "USA"),
                department);
        student.registerCourse(course);
        assignments.getFirst().setScores(new ArrayList<>(List.of(88)));
        assignments.get(1).setScores(new ArrayList<>(List.of(0)));

        int[] averages = course.calcStudentsAverage();
        Assertions.assertEquals(35, averages[0]);
    }
}
