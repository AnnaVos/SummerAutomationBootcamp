package chapterNine;

import org.testng.annotations.Test;

public class CarGame {

    @Test
    public void RedCar() {

        Auto redCar = new Auto();
        redCar.setColor("Red");
        redCar.setBrand("Volvo");
        redCar.setDoors("4");
        redCar.setMotorType("1.8", 10, 3000);
    }
    @Test
    public void MyCar() {

        AutoAdvanced myCar = new AutoAdvanced("Ford", 5, 3500);

    }
   }
