package junit5tests;

import listeners.Listener;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(Listener.class)
public class AssertionsTest {

    @Test
    void assertEqualsTest() {

        // Asserting that two String values are equal
        assertEquals("firstString", "secondString", "The String values were not equal");
    }

    @Test
    void assertEqualListTest() {
        List<String> expectedValues = Arrays.asList("firstString", "secondString", "thirdString");
        List<String> actualValues = Arrays.asList("firstString", "secondString");

        // Asserting that two lists are equal
        assertEquals(expectedValues, actualValues);
    }

    @Test 
    void assertArraysEqualsTest() {
        int[] expectedValues = {1, 5, 3};
        int[] actualValues = {1, 2, 3};

        // Asserting that two arrays are equal
        assertArrayEquals(expectedValues, actualValues);
    }

    @Test
    void assertTrueTest() {

        // Asserting that a boolean condition is true
        assertTrue(false, "This boolean condition did not evaluate to true");
    }

    @Test
    void assertThrowsTest() {

        // Asserting that a NullPointerException is thrown when the method is called
        assertThrows(NullPointerException.class, null);
    }

    @Test
    void assertAllTest() {

        // Using assertAll to group multiple assertions together
        // If any assertion fails, the test will fail and report all failures
        assertAll(
            () -> assertEquals("firstString", "secondString", "The String values were not equal"),
            () -> assertThrows(NullPointerException.class, null),
            () -> assertTrue(false, "This boolean condition did not evaluate to true"));
    }

    @Test
    void assertForMapTest() {
        Map<String, Integer> theMap = new HashMap<>();
        theMap.put("firstKey", 1);
        theMap.put("secondKey", 2);
        theMap.put("thirdKey", 3);

        // Using Hamcrest's hasKey and hasValue matchers to check if the map contains specific key-value pairs
        assertThat(theMap, Matchers.hasKey("secondKey1"));
        assertThat(theMap, Matchers.hasValue(22));
    }

    @Test
    void assertForList() {
        List<String> theList = Arrays.asList("firstString", "secondString", "thirdString");

        // Using Hamcrest's hasItem matcher to check if the list contains "thirdString"
        assertThat(theList, Matchers.hasItem("thirdStrings"));
    }

    @Test
    void assertForAny() {
        List<String> theList = Arrays.asList("firstString", "secondString", "thirdString");

        // Using Hamcrest's anyOf matcher to check if the list contains either "thirdString" or "noString"
        // This will pass if at least one of the conditions is true        
        assertThat(theList, Matchers.anyOf(Matchers.hasItem("thirdStrings"), Matchers.hasItem("noString")));
    }

    @Test
    void assertForContainsAnyOrder() {
        List<String> theList = Arrays.asList("firstString", "secondString", "thirdString");

        //  Using Hamcrest's containsInAnyOrder matcher to check if the list contains the specified items in any order
        // This will pass if the list contains all the specified items, regardless of their order     
        assertThat(theList, Matchers.containsInAnyOrder("thirdString","firstString", "secondString"));
    }

}
