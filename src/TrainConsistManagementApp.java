import java.util.*;
import java.util.stream.*;

class PassengerBogie {
    String id;
    String type;
    int capacity;

    PassengerBogie(String id, String type, int capacity) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        List<PassengerBogie> bogies = new ArrayList<>();

        for (int i = 1; i <= 100000; i++) {
            bogies.add(new PassengerBogie("BG" + i, "Sleeper", i % 100));
        }

        long startLoop = System.nanoTime();

        List<PassengerBogie> loopResult = new ArrayList<>();
        for (PassengerBogie b : bogies) {
            if (b.capacity > 50) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();

        long startStream = System.nanoTime();

        List<PassengerBogie> streamResult = bogies.stream()
                .filter(b -> b.capacity > 50)
                .collect(Collectors.toList());

        long endStream = System.nanoTime();

        long loopTime = endLoop - startLoop;
        long streamTime = endStream - startStream;

        System.out.println("Loop Time: " + loopTime + " ns");
        System.out.println("Stream Time: " + streamTime + " ns");

        if (loopTime < streamTime) {
            System.out.println("Loop is faster");
        } else {
            System.out.println("Stream is faster");
        }
    }
}