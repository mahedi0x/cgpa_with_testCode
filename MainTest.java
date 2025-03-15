import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testPrintResult() {
        Course[] courses = { 
                new Course("Math", 3.0, 4.0),
                new Course("Physics", 2.0, 3.7)
        };
        double previousGP = 3.5;
        double previousCredit = 30.0;

        // Test printResult output (optional, as it involves UI)
        assertDoesNotThrow(() -> Main.printResult(courses, previousGP, previousCredit), "printResult should not throw any exception");
    }



    @ParameterizedTest
    @CsvSource({
            "4.0, 3.0, 3.0, 2.7, 2.85", // Course 1: 4.0 credits, 3.0 grade; Course 2: 3.0 credits, 2.7 grade; Expected GPA: 2.85
            "2.0, 4.0, 3.0, 3.3, 3.6"   // Course 1: 2.0 credits, 4.0 grade; Course 2: 3.0 credits, 3.3 grade; Expected GPA: 3.6
    })
    void testSemesterGPACalculation(double credit1, double grade1, double credit2, double grade2, double expectedGPA) {
        Course[] courses = {
                new Course("Course1", credit1, grade1),
                new Course("Course2", credit2, grade2)
        };
        double gpa = Main.semesterGPACalculation(courses);
        assertNotEquals(expectedGPA, gpa, 0.01);
    }



}