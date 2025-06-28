package junit5tests;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.OS;

public class DisabledEnabledTest {

    @Test
    @Disabled(value = "Diabled for demo of @Disabled") // This test will not run
    void firstTest() {
        System.out.println("This is the first test method");
    }

    @Test
    @DisabledOnOs(value = OS.MAC, disabledReason = "Disabled for demo of @DisabledOnOs") // This test will not run on Mac OS
    void secondTest() {
        System.out.println("This is the second test method");
    }

    @Test
    @DisabledIfSystemProperty(named = "env", matches =  "staging") // This test will not run if the system property "env" is set to "staging"
    void thirdTest() {
        System.out.println("This is the third test method");
    }

    @Test
    @DisabledIf(value = "provider", disabledReason = "Disabled for demo of @DisabledIf") // This test will not run if the provider method returns true
    void fourthTest() {
        System.out.println("This is the fourth test method");
    }

    @Test
    void fifthTest() {
        System.out.println("This is the fifth test method");
    }

    boolean provider() {
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.SATURDAY);
    }
}
