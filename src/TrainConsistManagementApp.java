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

class Train {
    ArrayList<PassengerBogie> bogies = new ArrayList<>();

    void addBogie(PassengerBogie b) {
        bogies.add(b);
        System.out.println("Bogie added");
    }

    void displayAll() {
        for (PassengerBogie b : bogies) {
            b.display();
        }
    }

    void sortById() {
        Collections.sort(bogies, Comparator.comparing(b -> b.id));
        System.out.println("Sorted by ID");
    }

    void binarySearch(String searchId) {
        int left = 0;
        int right = bogies.size() - 1;
        boolean found = false;

        while (left <= right) {
            int mid = (left + right) / 2;
            PassengerBogie midBogie = bogies.get(mid);

            int cmp = midBogie.id.compareToIgnoreCase(searchId);

            if (cmp == 0) {
                System.out.println("Bogie found:");
                midBogie.display();
                found = true;
                break;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (!found) {
            System.out.println("Bogie not found");
        }
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
            System.out.println("3 Sort by ID");
            System.out.println("4 Binary Search");
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
                    train.sortById();
                    break;

                case 4:
                    sc.nextLine();
                    System.out.print("Enter ID to search: ");
                    String search = sc.nextLine();
                    train.binarySearch(search);
                    break;
            }

        } while (choice != 5);
    }
}