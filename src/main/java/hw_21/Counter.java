package hw_21;

public class Counter {
    private static int counter = 0;

    public static synchronized int increment() {
        System.out.printf("%s: %d%n", Thread.currentThread().getName(), counter);
        return ++counter;
    }
}
