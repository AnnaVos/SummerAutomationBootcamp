package moveWebsiteExercises;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Percentage;
import org.testng.annotations.Test;

public class Controles {

    @Test
    public void assertBoolean () {
        boolean testPlanReady = true;

        Assertions.assertThat(testPlanReady).as("Test Plan is not yet ready.").isTrue();
    }

    @Test
    public void assertStringContains () {
        String text = "Home";
        Assertions.assertThat(text).as("Is not uppercase").isUpperCase();
    }

    @Test
    public void assertIntegerGreaterThan () {
        int testInt = 3;
                Assertions.assertThat(testInt).as("Number of iPods is not close to 2").isCloseTo(25, Percentage.withPercentage(10));
    }
}
