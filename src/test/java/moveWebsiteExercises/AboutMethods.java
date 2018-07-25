package moveWebsiteExercises;

/* http://mvnrepository.com/artifact om bv selenium en driver in de POM te zetten
voor selenium: zoek op selenium-java, voor chrome zoek: webdrivermanager

Selenium praat tegen de DOM  aan (F12), dit is de code van de website (die je niet ziet in de normale browser).
 */

import org.testng.annotations.Test;

public class AboutMethods {

    private int multiply(int numberOne, int numberTwo) {
        return numberOne + numberTwo;
    }

    @Test
    public void printProduct() {
        System.out.println(multiply(5,8));
    }

}
