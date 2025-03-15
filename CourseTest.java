import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

class CourseTest {

    // -------------------------CsvSource----------------------
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

    // ------------------ValueSource-----------------------
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 })
    void testSetGrade(int grade) {
        Course course = new Course("Math", 3.0, 4.0);
        course.setGrade(grade);
        assertNotNull(course.getGrade(), "Grade should not be null");
    }

    // --------------------MethodSource-------------------------
    @ParameterizedTest
    @MethodSource("provideGradesForSetGrade")
    void testSetGradeWithMethodSource(int grade, double expectedGrade) {
        Course course = new Course("Math", 3.0, 4.0);
        course.setGrade(grade);
        assertEquals(expectedGrade, course.getGrade(), "Grade should match expected value");
    }

    private static Stream<Arguments> provideGradesForSetGrade() {
        return Stream.of(
                Arguments.of(0, 4.0),
                Arguments.of(1, 3.75),
                Arguments.of(2, 3.50), 
          
        );
    }

    // ------------------CsvFileSource-----------------------
    // @ParameterizedTest
    // @CsvFileSource(resources = "/coursegrades.csv", numLinesToSkip = 1)
    // void testSetGradeWithCsvFileSource(int grade, double expectedGrade) {
    // Course course = new Course("Math", 3.0, 4.0);
    // course.setGrade(grade);
    // assertEquals(expectedGrade, course.getGrade(), "Grade should match expected
    // value");
    // }

}
