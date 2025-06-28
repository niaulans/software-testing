package junit5tests;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class OrderedClassTest {

    @BeforeAll
    void beforeAll() {
        System.out.println("--This is the before all method");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("----This is the before each method");
    }

    @AfterAll
    void afterAll() {
        System.out.println("--This is the after all method");
    }

    @AfterEach
    void afterEach() {
        System.out.println("----This is the after each method");
    }

    @Test
    @DisplayName("US1234 - TC122")
    void firstMethod() {
        System.out.println("This is the first method");
    }

    @Test
    @DisplayName("US1234 - TC123")
    void secondMethod() {
        System.out.println("This is the second method");
    }

    @Test
    @DisplayName("US1234 - TC121")
    void thirdTest() {
        System.out.println("This is the third method");
    }
}
