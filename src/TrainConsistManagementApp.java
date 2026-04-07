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

    void display() {
        System.out.println(id + " | " + type + " | " + capacity);
    }
}

class CapacityComparator implements Comparator<PassengerBogie> {
    public int compare(PassengerBogie a, PassengerBogie b) {
        return b.capacity - a.capacity;
    }
}

class Train {
    ArrayList<PassengerBogie> bogies = new ArrayList<>();
    HashMap<String, Integer> bogieMap = new HashMap<>();

    void addBogie(PassengerBogie b) {
        if (bogieMap.containsKey(b.id)) {
            System.out.println("Duplicate ID not allowed");
        } else {
            bogies.add(b);
            bogieMap.put(b.id, b.capacity);
            System.out.println("Bogie added");
        }
    }

    void displayAll() {
        for (PassengerBogie b : bogies) {
            b.display();
        }
    }

    void sortByCapacity() {
        Collections.sort(bogies, new CapacityComparator());
        System.out.println("Sorted by capacity");
    }

    void filterByCapacity(int minCapacity) {
        List<PassengerBogie> result = bogies.stream()
                .filter(b -> b.capacity >= minCapacity)
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No bogies found");
        } else {
            for (PassengerBogie b : result) {
                b.display();
            }
        }
    }

    void groupByType() {
        Map<String, List<PassengerBogie>> grouped =
                bogies.stream().collect(Collectors.groupingBy(b -> b.type));

        for (String type : grouped.keySet()) {
            System.out.println("\nType: " + type);
            for (PassengerBogie b : grouped.get(type)) {
                b.display();
            }
        }
    }

    void totalCapacity() {
        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, (a, b) -> a + b);

        System.out.println("Total Seating Capacity: " + total);
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Train train = new Train();

        int choice;

        do {
            System.out.println("\n1 Add Bogie");
            System.out.println("2 Display All");
            System.out.println("3 Sort by Capacity");
            System.out.println("4 Filter by Capacity");
            System.out.println("5 Group by Type");
            System.out.println("6 Total Capacity");
            System.out.println("7 Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter type: ");
                    String type = sc.nextLine();
                    System.out.print("Enter capacity: ");
                    int cap = sc.nextInt();
                    train.addBogie(new PassengerBogie(id, type, cap));
                    break;

                case 2:
                    train.displayAll();
                    break;

                case 3:
                    train.sortByCapacity();
                    break;

                case 4:
                    System.out.print("Enter minimum capacity: ");
                    int min = sc.nextInt();
                    train.filterByCapacity(min);
                    break;

                case 5:
                    train.groupByType();
                    break;

                case 6:
                    train.totalCapacity();
                    break;
            }

        } while (choice != 7);
    }
}