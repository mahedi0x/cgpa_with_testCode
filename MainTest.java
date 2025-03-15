
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private Course course;


    @BeforeEach
    void setUp() {
        course = new Course("SVT", 3, "A");
    }

    @BeforeAll
    static void setUpAll() {
        System.out.println("Initialization beforeAll test..");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Initialization afterAll test..");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Initialization afterEach test...");
    }

    //-------------------assertEqual/assertNotEqual---------------------
    @Test
    void testSetGradeAssertEquals(){
        Course course = new Course("BST", 3, "A");
        course.setGrade(0);
        assertEquals(4.0, course.getGrade(), "Grade should be 4.0 for input 0");
    }

    @Test
    void testSetGradeAssertNotEquals(){
        course.setGrade(0);
        assertNotEquals(3, course.getGrade());
    }



    //---------------------assertNull/assertNotNull----------------------
    @Test
    void testCourseNull(){
        course = new Course("SVT", 3, "A+");
        assertNull(course.emptyValue());
    }

    @Test
    void testCourseNotNull(){
        course = new Course("OS", 3, "A+");
        assertNotNull(course,"Course object should not be null");
    }



    //----------------------assertSame/assertNotSame---------------------------
    @Test
    void testSameCourseName() {
        Course course1 = new Course("BST", 2, "B+");
        Course course2 = new Course("Operating System", 2, "B+");
        Course course3 = course1;

        assertSame(course1,course3);
        assertNotSame(course1,course2);
    }

    @Test
    void testNotSameObject() {
        Course course1 = new Course("BST", 2, "B+");
        Course course2 = new Course("Operating System", 2, "B+");
        assertNotSame(course1, course2, "Different objects should not be same");
    }



// ------------------------assertTrue/assertNotTrue-------------------------------

    @Test
    void testCourseTrue(){
        Course course1 = new Course("BST", 2, "B+");
        Course course2 = new Course("Operating System", 2, "B+");
        Course course3 = course1;

        assertTrue(course1.getName().equals(course3.getName()));
    }


    @Test
    void testCourseFalse(){
        Course course1 = new Course("BST", 2, "B+");
        Course course2 = new Course("Operating System", 2, "B+");

        assertTrue(course2.getName().equals(course1.getName()));
    }


    //---------------------------assertThrow/assertDoesNotThrow---------------------------
    @Test
    void testPrintResult() {
        Course[] courses = {
                new Course("Software Verification", 3.0, 4.0),
                new Course("Operating System", 2.0, 3.75)
        };
        double previousGradePoint = 3.5;
        double previousCredit = 20.0;

        assertDoesNotThrow(() -> Main.printResult(courses, previousGradePoint, previousCredit), "printResult should execute without exceptions");
    }


    //---------------------------assertArrayEquals---------------------
    @Test
    void testArrayEquals() {
        Course course = new Course("BST", 2, "A+");
        course.setGrade(8);
        course.setCredit(4);

        double[] originalArray = {2.0, 4.0};
        double[] makeArray = {course.getGrade(), course.getCredit()};
        assertArrayEquals(originalArray, makeArray, "The arrays should match");
    }


    //------------------------assertTimeOut--------------------
    @Test
    void testTimeoutExecution() {
        assertTimeout(java.time.Duration.ofSeconds(1), () -> {
            Thread.sleep(500); // Simulating a process
        });
    }

}