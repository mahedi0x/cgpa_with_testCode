package Project.CGPA;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

private Course course;
private Main mainApp;

@BeforeEach
void setUp() {
course = new Course("Math", 3, "A");
mainApp = new Main();
}

@Test
void testCourseInitialization() {
assertNotNull(course, "Course object should not be null");
}


@Test
void testSameCourseName() {
Course anotherCourse = course;
assertSame(course, anotherCourse, "Same object reference should match");
}

@Test
void testNotSameObject() {
Course anotherCourse = new Course("Math", 3, "A");
assertNotSame(course, anotherCourse, "Different objects should not be same");
}


}
