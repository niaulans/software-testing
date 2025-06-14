package junit5tests;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class TaggedTest {

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
    @Tag("acceptance")
    void firstMethod() {
        System.out.println("This is the first method");
    }

    @Test
    @Tag("regression")
    @DisplayName("US1234 - TC12")
    void secondMethod() {
        System.out.println("This is the second method");
    }

    @Test
    @Tag("regression")
    void thirdMethod() {
        System.out.println("This is the third method");
    }

    @Tag("acceptance")
    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1, 5, 6})
    void intValues(int theParam) {
        System.out.println("theParam = " + theParam);
    }
}
