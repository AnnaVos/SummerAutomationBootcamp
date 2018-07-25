package moveWebsiteExercises;

import org.testng.annotations.Test;

/*
ctrl + alt + L voor code opmaak
annotaties (hier heb je Maven voor nodig): @Test (rechtermuis op lampje en kies methode om te importeren, bv TestNG of JUnit)
@BeforeMethod
*/

public class HelloWorldTest {

    @Test
    public void printText() {
        System.out.println("Hello World");
        // Run: dan verschijnt de target map
    }
}
