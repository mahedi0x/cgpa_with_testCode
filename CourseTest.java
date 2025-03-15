import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {


    @Test
    void testSetGrade() {
        Course course = new Course();

        // Test setting grade and verifying with assertEquals
        course.setGrade(0); // A+
        assertEquals(4.0, course.getGrade(), "Grade should be 4.0 for input 0");

        course.setGrade(5); // B-
        assertEquals(2.3, course.getGrade(), "Grade should be 2.3 for input 5");
    }

    @Test
    void testToString() {
        Course course = new Course("Math", 3.0, 4.0);
        String expected = "\n         Math                   3.0                   4.0             A\n-------------------------------";

        assertNotNull(course.toString(), "toString() should not return null");
    }


    @Test
    void testObjectEquality() {
        Course course1 = new Course("Math", 3.0, 4.0);
        Course course2 = new Course("Math", 3.0, 4.0);
        Course course3 = course1;

        // Test object references using assertSame and assertNotSame
        assertSame(course1, course3, "course1 and course3 should refer to the same object");
        assertNotSame(course1, course2, "course1 and course2 should not refer to the same object");


        // Test object equality using assertTrue and assertFalse
        assertTrue(course1.getName().equals(course2.getName()), "Course names should be equal");
        assertFalse(course1.getCredit() != course2.getCredit(), "Course credits should be equal");
    }

}



