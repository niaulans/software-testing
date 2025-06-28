package junit5tests;

import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AssumptionsTest {

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1, 5, 6})
    void intValues(int theParam) {

        // This will skip the test if theParam is less than or equal to 4
        assumeTrue(theParam > 4);
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest
    @CsvSource(value = {"Steve,Rogers", "Captain,America", "Bucky,Barnes"})
    void csvSource_StringString(String param1, String param2) {

        // This will skip the test if param1 is "Steve"
        assumeFalse(param1.equals("Steve"), "The assumption failed for the following param2: " + param2);
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"Steve,32,true", "Captain,21,false", "Bucky,5,true"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3) {

        // This will skip the test if param2 is less than or equal to 20
        assumingThat(param2 > 20, () -> System.out.println("This code ran"));
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }
}
