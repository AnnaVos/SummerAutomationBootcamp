package chapterNine;

public class AutoAdvanced {

    public String brand;

    public AutoAdvanced(String brand, int hP, int rPM) {
        this.brand = brand;
        System.out.println("Brand of your car is: " + brand);
        int torque = calculateTorque(hP,rPM);
        System.out.println("The torque of your car is: " + torque);
    }

    public int calculateTorque(int hP, int rPM) {
        int torque = (hP * 5252) / rPM;
        return torque;
    }
}

