package ua.khpi.oop.kononenko16;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

public class Generator {

    public static ArrayList<Trip> generator(int size) {
        int sits, num;
        char b, c;
        ArrayList<Trip> list = new ArrayList<>();
        String[] namesOfDays = new String[]{
                "sun", "mon", "tues", "wed", "thur", "fri", "sat"
        };
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < size; i++) {
            Trip test = new Trip();
            MyDate now = new MyDate();
            sits = (int) (Math.random() * 55 + 10);
            num = (int) (Math.random() * 999 + 1);
            b = AlphaNumericString.charAt((int) (Math.random() * 25));
            c = AlphaNumericString.charAt((int) (Math.random() * 25));
            StringBuilder numberGenerator = new StringBuilder();
            test.setSits(sits);

            final Random random = new Random();
            final int millisInDay = 24 * 60 * 60 * 1000;
            Time time = new Time((long) random.nextInt(millisInDay));

            now.setHours(time.getHours());
            now.setMinutes(time.getMinutes());
            test.setDeparture(now);

            numberGenerator.append(num);
            numberGenerator.append(b);
            numberGenerator.append(c);

            test.setNumTrip(numberGenerator.toString());
            test.setDays(namesOfDays[(int) (Math.random() * 6)]);
            list.add(test);

        }



        return list;
    }

}
