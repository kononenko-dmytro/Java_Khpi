package ua.khpi.oop.kononenko13_14;

import ua.khpi.oop.kononenko09_12.Input;
import ua.khpi.oop.kononenko09_12.MyDate;
import ua.khpi.oop.kononenko09_12.Regex;
import ua.khpi.oop.kononenko09_12.Trip;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThreadTask {

    public static void test1() throws InterruptedException {
        int count = 0;
        System.out.println("First Thread started");
        try {
            for (Trip elem : Helper.object) {
                if (!Thread.currentThread().isInterrupted()) {
                    if (Regex.checkWeekends(elem.getDays())) {
                        count++;
                    }
                } else {
                    throw new InterruptedException();
                }
            }
            System.out.println("Number of trips in weekends: " + count);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void test2() throws InterruptedException {
        int count = 0;
        System.out.println("Second Thread started");
        try {
            for (Trip elem : Helper.object) {
                if (!Thread.currentThread().isInterrupted()) {
                    count += elem.getSits();
                } else {
                    throw new InterruptedException();
                }
            }
            count /= Helper.object.size();
            System.out.println("Average number of sits: " + count);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void test3() throws InterruptedException {
        MyDate now = new MyDate(00, 00);
        System.out.println("Third Thread started");
        try {
            for (Trip elem : Helper.object) {
                if (!Thread.currentThread().isInterrupted()) {
                    if (now.getToCompare() < elem.getDeparture().getToCompare()) {
                        now = elem.getDeparture();
                    }
                } else {
                    throw new InterruptedException();
                }
            }
            System.out.println("Earliest trip is at: " + now);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }


    public static void startThreads() {
        System.out.println("Set the timer [0 - 100 000 ms]: ");
        int timer_num = Input.enterSits();
        System.out.println("Starting all threads...");

        Thread1 first = new Thread1();
        Thread t1 = new Thread(first, "FirstThread");

        Thread2 second = new Thread2();
        Thread t2 = new Thread(second, "SecondThread");

        Thread3 third = new Thread3();
        Thread t3 = new Thread(third, "ThirdThread");

        t1.start();
        t2.start();
        t3.start();
        Timer timer = new Timer(timer_num, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("Interrupting thread...");
                t1.interrupt();
                t2.interrupt();
                t3.interrupt();
            }
        });
        timer.setRepeats(false);
        timer.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            timer.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finishing all threads...");
    }

    public static long cParallel() {
        long time_start = System.currentTimeMillis();
        System.out.println("Starting all threads...");
        Thread1 first = new Thread1();
        Thread t1 = new Thread(first, "FirstThread");

        Thread2 second = new Thread2();
        Thread t2 = new Thread(second, "SecondThread");

        Thread3 third = new Thread3();
        Thread t3 = new Thread(third, "ThirdThread");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finishing all threads...");
        return System.currentTimeMillis() - time_start;
    }

    public static long comparisonSequential() {
        long time_start = System.currentTimeMillis();
        System.out.println("Starting sequence...");
        try {
            ThreadTask.test1();
            ThreadTask.test2();
            ThreadTask.test3();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finishing sequence...");
        return System.currentTimeMillis() - time_start;
    }

}

class Thread1 implements Runnable {
    public void run() {
        int count = 0;
        System.out.println("First Thread started");
        try {
            for (Trip elem : Helper.object) {
                if (!Thread.currentThread().isInterrupted()) {
                    if (Regex.checkWeekends(elem.getDays())) {
                        count++;
                    }
                } else {
                    throw new InterruptedException();
                }
            }
            System.out.println("Number of trips in weekends : " + count);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}

class Thread2 implements Runnable {
    public void run() {
        int count = 0;
        System.out.println("Second Thread started");
        try {
            for (Trip elem : Helper.object) {
                if (!Thread.currentThread().isInterrupted()) {
                    count += elem.getSits();
                } else {
                    throw new InterruptedException();
                }
            }
            count /= Helper.object.size();
            System.out.println("Average number of sits: " + count);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

    }
}

class Thread3 implements Runnable {
    public void run() {
        MyDate now = new MyDate(00, 00);
        System.out.println("Third Thread started");
        try {
            for (Trip elem : Helper.object) {
                if (!Thread.currentThread().isInterrupted()) {
                    if (now.getToCompare() < elem.getDeparture().getToCompare()) {
                        now = elem.getDeparture();
                    }
                } else {
                    throw new InterruptedException();
                }
            }
            System.out.println("Earliest trip is at : " + now);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}

