package bootcampDayFour;

import com.sun.org.apache.regexp.internal.RE;

public class EnumExample {

    public enum BootCampDays {
        DAY_ONE,
        DAY_TWO,
        DAY_THREE,
        DAY_FOUR,
        DAY_FIVE;
    }
    public static String checkBootcampDaysInfo (BootCampDays bootCampDays) {
        switch (bootCampDays) {
            case DAY_ONE:
                return "Zin an!";
            case DAY_TWO:
                return "Nog wel leuk, maar terug rijden was wel pittig.";
            case DAY_THREE:
                return "TGIF! Ohnee.. YESS dag drie!";
            case DAY_FOUR:
                return "Waar ging het vorige week ook alweer over?";
            case DAY_FIVE:
                return "Man man man";
             default:
                 return "Cursus is maar 5 dagen.";
        }
    }

}
