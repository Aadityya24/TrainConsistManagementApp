import java.util.*;

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

    void searchBogie(String id) {
        if (bogieMap.containsKey(id)) {
            System.out.println(id + " | Capacity: " + bogieMap.get(id));
        } else {
            System.out.println("Bogie not found");
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
            System.out.println("4 Search Bogie");
            System.out.println("5 Exit");

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
                    sc.nextLine();
                    System.out.print("Enter ID: ");
                    String search = sc.nextLine();
                    train.searchBogie(search);
                    break;
            }

        } while (choice != 5);
    }
}