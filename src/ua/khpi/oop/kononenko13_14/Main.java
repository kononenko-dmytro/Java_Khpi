package ua.khpi.oop.kononenko13_14;

public class Main {

    public static void main(String[] args) {
        try {
            Helper.starter(args);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Woops........Error");
            System.err.println(e.getMessage());
        }
    }
}
