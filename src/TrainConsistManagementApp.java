import java.util.*;

class Bogie {
    String type;

    Bogie(String type) {
        this.type = type;
    }

    void display() {
        System.out.println("Bogie Type: " + type);
    }
}

class PassengerBogie extends Bogie {
    int capacity;

    PassengerBogie(String type, int capacity) {
        super(type);
        this.capacity = capacity;
    }

    void display() {
        System.out.println(type + " Passenger Bogie | Capacity: " + capacity);
    }
}

class GoodsBogie extends Bogie {
    String cargoType;

    GoodsBogie(String type, String cargoType) {
        super(type);
        this.cargoType = cargoType;
    }

    void display() {
        System.out.println(type + " Goods Bogie | Cargo: " + cargoType);
    }
}

class Train {
    List<Bogie> bogies = new ArrayList<>();

    void addBogie(Bogie b) {
        bogies.add(b);
    }

    void displaySummary() {
        int totalCapacity = 0;

        System.out.println("\n--- Train Consist Summary ---");

        for (Bogie b : bogies) {
            b.display();

            if (b instanceof PassengerBogie) {
                totalCapacity += ((PassengerBogie) b).capacity;
            }
        }

        System.out.println("Total Bogies: " + bogies.size());
        System.out.println("Total Passenger Capacity: " + totalCapacity);
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        Train train = new Train();

        train.addBogie(new PassengerBogie("Sleeper", 72));
        train.addBogie(new PassengerBogie("AC Chair", 60));
        train.addBogie(new PassengerBogie("First Class", 40));
        train.addBogie(new GoodsBogie("Rectangular", "Coal"));
        train.addBogie(new GoodsBogie("Cylindrical", "Oil"));

        train.displaySummary();
    }
}