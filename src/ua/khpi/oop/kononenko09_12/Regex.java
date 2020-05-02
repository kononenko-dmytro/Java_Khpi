package ua.khpi.oop.kononenko09_12;

public class Regex {

    public static boolean checkWeekends(String input) {
        return input.matches("[\\S\\s]*(sat(ur)?|sun)(day)?[\\S\\s]*");
    }

    public static boolean checkTime(String input) {
        return input.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]");
    }

    public static boolean checkTimeAM(String input) {
        return input.matches("([0][0-9]|[01][0-1]):[0-5][0-9]");
    }

    public static boolean checkNum(String input) {
        return input.matches("[0-9]{1,4}[a-zA-Z]{2}");
    }

    public static boolean checkSits(String input) {
        return input.matches("[0-9]+");
    }

    public static boolean checkName(String input) {
        return input.matches("^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$");
    }

    public static boolean checkDays(String input) {
        return input.matches("^(mon|tues|wed(nes)?|thur(s)?|fri|sat(ur)?|sun)(day)?" +
                "(,\\s*(mon|tues|wed(nes)?|thur(s)?|fri|sat(ur)?|sun)(day)?)*");
    }

    public static boolean checkStations(String input,String[] station) {
        return input.matches("[\\S\\s]*("+ station[0] +")[\\s\\S]*("+station[1]+")[\\s\\S]*("+ station[2] +")[\\s\\S]*");
    }
}
