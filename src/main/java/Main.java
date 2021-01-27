import hw_22.LockExample;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //1
        System.out.println("Atomic decrementing 20000 times started");

        var size = 20000;
        var value = new AtomicInteger(size);

        var parentThreads = new Thread[2];
        var childThreads = new Thread[size];

        IntStream.range(0, 2).forEach(i -> {
            var parentThread = new Thread(() -> {
                var start = i * size / 2;
                IntStream.range(start, start + size / 2).parallel().forEach(j -> {
                    var childThread = new Thread(value::decrementAndGet);
                    childThread.start();
                    childThreads[j] = childThread;
                });
            });
            parentThread.start();
            parentThreads[i] = parentThread;
        });

        Arrays.stream(parentThreads).forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Arrays.stream(childThreads).forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.printf("Atomic decrementing %d times finished with value %d\n\n", size, value.get());

        //2
        var lockExample = new LockExample();

        for(int i = 0; i < 3; ++i) {
            Thread t = new Thread(lockExample::algorithm);
            t.start();
        }
    }
}
