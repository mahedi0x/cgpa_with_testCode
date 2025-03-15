import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @ParameterizedTest
    @CsvSource({
            "4.0, 3.0, 3.0, 2.7, 2.85", 
            "2.0, 4.0, 3.0, 3.3, 3.6"   
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



