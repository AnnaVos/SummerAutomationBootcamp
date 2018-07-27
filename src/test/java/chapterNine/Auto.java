package chapterNine;


public class Auto {

    public void setColor(String carColor){
        System.out.println("The color of your car is: " + carColor);
    }

    public void setBrand (String carBrand) {
        System.out.println("The brand of your car is: " + carBrand);
    }

    public void setDoors(String carDoors){
        System.out.println("Your car has " + carDoors + " doors." );
    }

    public void setMotorType (String carMotor, int hP, int rPM){
        System.out.println("Your cars engine is: " + carMotor + " with a torque of " + calculateTorque(hP, rPM ));
    }

    public int calculateTorque (int hP, int rPM) {

        return (hP * 5252)/rPM;
    }
}

