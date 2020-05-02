package ua.khpi.oop.kononenko09_12;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    private static Scanner in = new Scanner(System.in);

    public static Trip insert() {
        Trip output = new Trip();

        output.setNumTrip(enterNum());
        output.setSits(enterSits());
        output.setDays(enterDays());
        output.setDeparture(enterTime());
        output.setStorage(enterStations());

        return output;
    }

    private static MyDate enterTime() {


        System.out.println("Input time of arriving/departure(hh:mm): ");
        String time = in.next();
        while (!Regex.checkTime(time)) {
            System.out.print("WARNING: Invalid time. Try again: ");
            time = in.next();
        }

        return parser(time);
    }

    private static String enterDays() {


        System.out.println("Input days of work: ");
        String days = in.next();
        while (!Regex.checkDays(days)) {
            System.out.print("WARNING: Invalid days. Try again: ");
            days = in.next();
        }

        return days;
    }

    public static String enterName() {


        System.out.println("Input name of the station: ");
        String name = in.next();
        while (!Regex.checkName(name)) {
            System.out.print("WARNING: Invalid name. Try again: ");
            name = in.next();
        }

        return name;
    }

    public static int enterSits() {
        System.out.println("Input number: ");
        String output = in.next();
        while (!Regex.checkSits(output)) {
            System.out.print("WARNING: invalid number. Try again: ");
            output = in.next();
        }
        return Integer.parseInt(output);
    }

    private static String enterNum() {


        System.out.println("Input number of trip(xxxxFF): ");
        String numb = in.next();
        while (!Regex.checkNum(numb)) {
            System.out.print("WARNING: Invalid number. Try again: ");
            numb = in.next();
        }

        return numb;
    }

    private static ArrayList<Station> enterStations() {
        String tempStr;
        Station tempSt;
        ArrayList<Station> output = new ArrayList<>();
        Scanner in2 = new Scanner(System.in);

        System.out.print("Input stations \n\t\t(use exit to stop adding): ");
        tempStr = in2.nextLine();
        while (!tempStr.equals("exit")) {
            tempSt = new Station();
            tempSt.setName(enterName());
            tempSt.setTime(enterTime());
            output.add(tempSt);
            System.out.print("Input stations \n\t\t(use exit to stop adding): ");
            tempStr = in2.nextLine();
        }
        return output;
    }

    private static MyDate parser(String input) {
        MyDate output = new MyDate();

        String[] arrOfStr = input.split(":");

        output.setHours(Integer.parseInt(arrOfStr[0]));
        output.setMinutes(Integer.parseInt(arrOfStr[1]));

        return output;
    }

}
