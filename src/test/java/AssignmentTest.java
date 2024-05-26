import org.example.Assignment;
import org.example.Course;
import org.example.Department;
import org.example.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AssignmentTest {
    @Test
    public void testCalcAssignmentAvg1() {
        Assignment assignment = new Assignment("Assignment1", 1.0, 100);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(75);
        scores.add(40);
        assignment.setScores(scores);
        assignment.calcAssignmentAvg();
        Assertions.assertEquals(57.5, assignment.getAssignmentAverage());
    }

    @Test
    public void testCalcAssignmentAvg2() {
        Assignment assignment = new Assignment("Assignment1", 1.0, 100);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(75);
        scores.add(40);
        scores.add(90);
        assignment.setScores(scores);
        assignment.calcAssignmentAvg();
        Assertions.assertEquals(205.0 / 3.0, assignment.getAssignmentAverage());
    }

    @Test
    public void testCalcAssignmentAvg3() {
        Assignment assignment = new Assignment("Assignment1", 1.0, 100);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(75);
        scores.add(40);
        scores.add(0);
        assignment.setScores(scores);
        assignment.calcAssignmentAvg();
        Assertions.assertEquals(115.0 / 3.0, assignment.getAssignmentAverage());
    }
// there is no method called this inside of Assignment class.
// The closest we have to this method would be isAssignmentWeightValid.
// I will test that assuming that is what you wanted us to do
    @Test
    public void testIsAssignmentsTotalWeightValid1() {
        Department department = new Department("D01", "Computer Science");
        ArrayList<Assignment> assignments = new ArrayList<Assignment>();
        assignments.add(new Assignment("Assignment1", 0.4, 100));
        assignments.add(new Assignment("Assignment2", 0.6, 100));

        Course course = new Course("01", "Programming", 4, department,
                assignments, new ArrayList<Student>(), new ArrayList<Double>());
        Assertions.assertTrue(course.isAssignmentWeightValid());
    }

    @Test
    public void testIsAssignmentsTotalWeightValid2() {
        Department department = new Department("D01", "Computer Science");
        ArrayList<Assignment> assignments = new ArrayList<Assignment>();
        assignments.add(new Assignment("Assignment1", 1.4, 100));
        assignments.add(new Assignment("Assignment2", 0.6, 100));

        Course course = new Course("01", "Programming", 4, department,
                assignments, new ArrayList<Student>(), new ArrayList<Double>());
        Assertions.assertFalse(course.isAssignmentWeightValid());
    }

    @Test
    public void testIsAssignmentsTotalWeightValid3() {
        Department department = new Department("D01", "Computer Science");
        ArrayList<Assignment> assignments = new ArrayList<Assignment>();
        assignments.add(new Assignment("Assignment1", -1.4, 100));
        assignments.add(new Assignment("Assignment2", 1.0, 100));

        Course course = new Course("01", "Programming", 4, department,
                assignments, new ArrayList<Student>(), new ArrayList<Double>());
        Assertions.assertFalse(course.isAssignmentWeightValid());
    }

    @Test
    public void testIsAssignmentsTotalWeightValid4() {
        Department department = new Department("D01", "Computer Science");
        ArrayList<Assignment> assignments = new ArrayList<Assignment>();
        assignments.add(new Assignment("Assignment1", 0.0, 100));
        assignments.add(new Assignment("Assignment2", 1.0, 100));

        Course course = new Course("01", "Programming", 4, department,
                assignments, new ArrayList<Student>(), new ArrayList<Double>());
        Assertions.assertTrue(course.isAssignmentWeightValid());
    }

    @Test
    public void testIsAssignmentsTotalWeightValid5() {
        Department department = new Department("D01", "Computer Science");
        ArrayList<Assignment> assignments = new ArrayList<Assignment>();
        assignments.add(new Assignment("Assignment1", 1.0, 100));
        assignments.add(new Assignment("Assignment2", 0.0, 100));

        Course course = new Course("01", "Programming", 4, department,
                assignments, new ArrayList<Student>(), new ArrayList<Double>());
        Assertions.assertTrue(course.isAssignmentWeightValid());
    }
}
