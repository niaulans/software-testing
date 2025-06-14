package junit5tests;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class FirstClassTest {

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
        System.out.println("----This is tha after each method");
    }

    @Test
    void firstMethod() {
        System.out.println("This is the first method");
    }

    @Test
    @DisplayName("US1234 - TC12")
    void secondMethod() {
        System.out.println("This is the second method");
    }
}
