package ua.khpi.oop.kononenko13_14;

import ua.khpi.oop.kononenko09_12.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Helper {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static Scanner in = new Scanner(System.in);
    public static MyLinkedList<Trip> object = new MyLinkedList<>();

    public static void starter(String[] arg) {
        if (arg.length == 0) {
            menu();
        } else if ("-auto".equals(arg[0])) {
            autoMode();
        }
    }

    @SuppressWarnings("unchecked")
    private static void menu() {
        int choose;

        settings();
        choose = in.nextInt();
        while (choose != 0) {
            switch (choose) {
                case 1:
                    printList(object);
                    break;
                case 2:
                    object.add(Input.insert());
                    break;
                case 3:
                    remove(object);
                    break;
                case 4:
                    sorters(object);
                    break;
                case 5:
                    clear(object);
                    break;
                case 6:
                    toStr(object);
                    break;
                case 7:
                    Trip[] test = object.toArray(new Trip[object.size()]);
                    break;
                case 8:
                    save(object);
                    break;
                case 9:
                    object = download();
                    break;
                case 10:
                    settingSearch(object);
                    break;
                case 11:
                    object = Generator.generator(Input.enterSits());
                    break;
                case 12:
                    ThreadTask.startThreads();
                    break;
                case 13:
                    long b = ThreadTask.cParallel();
                    long j = ThreadTask.comparisonSequential();

                    System.out.println("Time via sequential: " + j);
                    System.out.println("Time via parallel: " + b);
                    break;
            }
            settings();
            choose = in.nextInt();
        }

    }

    @SuppressWarnings("unchecked")
    private static void save(MyLinkedList input) {
        int choose;
        System.out.println("What type of saving do you wish for: ");
        System.out.println("1 - XML");
        System.out.println("2 - Standard Serialization");
        System.out.println("Choose: ");
        choose = in.nextInt();
        try {
            if (choose == 1) {
                Serialization.LongTermPersistenceWrite(input, Files.controller());
            } else {
                Serialization.ObjectWrite(input, Files.controller());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static void autoMode() {
        object = download();
        menu();
    }

    public static boolean checker(Trip input) {

        return Regex.checkNum(input.getNumTrip())
                && Regex.checkTime(input.getDeparture().toString())
                && Regex.checkDays(input.getDays())
                && Regex.checkSits(String.valueOf(input.getSits()))
                && checkerAdvance(input.getStorage());
    }

    private static boolean checkerAdvance(ArrayList<Station> input) {
        for (Station elem : input) {

            if (!Regex.checkName(elem.getName())) {
                return false;
            }
            if (!Regex.checkTime(elem.getTime().toString())) {
                return false;
            }
        }
        return true;
    }

    private static MyLinkedList download() {
        MyLinkedList<Trip> output = new MyLinkedList<>();
        int choose;
        System.out.println("What type of saving do you wish for: ");
        System.out.println("1 - XML");
        System.out.println("2 - Standard Serialization");
        System.out.println("Choose: ");
        choose = in.nextInt();
        try {
            if (choose == 1) {
                output = Serialization.LongTermPersistenceRead(Files.controller());
            } else {
                output = Serialization.ObjectRead(output, Files.controller());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return output;
    }

    private static void settings() {

        System.out.println("Hello, you are now in menu.....");
        System.out.println("List of settings: ");
        System.out.println("0 - Exit");
        System.out.println("1 - Show data");
        System.out.println("2 - Insert");
        System.out.println("3 - Remove");
        System.out.println("4 - Sort");
        System.out.println("5 - Clear");
        System.out.println("6 - to String");
        System.out.println("7 - to Array");
        System.out.println("8 - Save");
        System.out.println("9 - Download");
        System.out.println("10 - Search");
        System.out.println("11 - Generate data");
        System.out.println("12 - Multithreaded");
        System.out.println("13 - Comparison");
        System.out.print("Select: ");

    }

    private static void settingAdvance() {
        System.out.println("List of settings: ");
        System.out.println("0 - Exit");
        System.out.println("1 - Sort by number of trip");
        System.out.println("2 - Sort by number of sits");
        System.out.println("3 - Sort by time of department");
        System.out.println("4 - Show data");
        System.out.print("Select: ");
    }

    @SuppressWarnings("unchecked")
    private static void sorters(MyLinkedList input) {
        int choose;

        settingAdvance();
        choose = in.nextInt();
        while (choose != 0) {
            switch (choose) {
                case 1:
                    input.sort(new Comparator<Trip>() {
                        @Override
                        public int compare(Trip o1, Trip o2) {
                            return extractInt(o1.getNumTrip()) - extractInt(o2.getNumTrip());
                        }

                        int extractInt(String s) {
                            String num = s.replaceAll("\\D", "");
                            // return 0 if no digits found
                            return num.isEmpty() ? 0 : Integer.parseInt(num);
                        }
                    }, input.toArray(new Trip[input.size()]));
                    break;
                case 2:
                    input.sort(new Comparator<Trip>() {
                        @Override
                        public int compare(Trip p1, Trip p2) {
                            if (p1.getSits() != p2.getSits()) {
                                return p1.getSits() - p2.getSits();
                            }
                            return 0;
                        }
                    }, input.toArray(new Trip[input.size()]));
                    break;
                case 3:
                    input.sort(new Comparator<Trip>() {
                        @Override
                        public int compare(Trip p1, Trip p2) {
                            if (p1.getDeparture().getToCompare() != p2.getDeparture().getToCompare()) {
                                return p1.getDeparture().getToCompare() - p2.getDeparture().getToCompare();
                            }
                            return 0;
                        }
                    }, input.toArray(new Trip[input.size()]));
                    break;
                case 4:
                    printList(input);
                    break;
            }
            settingAdvance();
            choose = in.nextInt();
        }
    }

    private static void settingSearch(MyLinkedList<Trip> input) {
        String[] stations = new String[3];
        for (int i = 0; i < 3; i++) {
            stations[i] = Input.enterName();
        }

        for (Trip elem : input) {
            if (search(elem, stations)) {
                System.out.println(elem);
            }
        }
    }

    private static void remove(MyLinkedList input) {
        int num;
        if (input.size() != 0) {
            System.out.println("Input number of note: ");
            num = in.nextInt();
            if (num >= 0 && num < input.size()) {
                input.remove(num);
            }
        } else {
            System.out.println("Error: arr is empty");
        }
    }

    private static void clear(MyLinkedList input) {

        System.out.print("Are you sure that you want delete list \n\t\t" + ANSI_RED + "\"Yes" + ANSI_GREEN + "|NO\":"
                + ANSI_RESET);
        if (in.next().matches("Yes|yes")) {
            input.clear();
        }
    }

    private static String toStr(MyLinkedList input) {
        return input.toString();
    }

    private static <E> void printList(MyLinkedList<E> input) {

        for (E elem : input) System.out.println(elem);

    }

    private static boolean search(Trip input, String[] input2) {

        if (Regex.checkTimeAM(input.getDeparture().toString())) {
            if (Regex.checkWeekends(input.getDays())) {
                return Regex.checkStations(input.getStorage().toString(), input2);
            }
        }
        return false;
    }

}
