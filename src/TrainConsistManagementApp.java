import java.util.*;

class EmptyTrainException extends Exception {
    EmptyTrainException(String msg) {
        super(msg);
    }
}

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
        if (bogies.isEmpty()) {
            System.out.println("Train is empty");
            return;
        }

        for (PassengerBogie b : bogies) {
            b.display();
        }
    }

    void binarySearch(String searchId) throws EmptyTrainException {
        if (bogies.isEmpty()) {
            throw new EmptyTrainException("Cannot search: Train has no bogies");
        }

        Collections.sort(bogies, Comparator.comparing(b -> b.id));

        int left = 0;
        int right = bogies.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            PassengerBogie midBogie = bogies.get(mid);

            int cmp = midBogie.id.compareToIgnoreCase(searchId);

            if (cmp == 0) {
                System.out.println("Bogie found:");
                midBogie.display();
                return;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("Bogie not found");
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
            System.out.println("3 Search Bogie (Binary)");
            System.out.println("4 Exit");

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
                    sc.nextLine();
                    System.out.print("Enter ID to search: ");
                    String search = sc.nextLine();

                    try {
                        train.binarySearch(search);
                    } catch (EmptyTrainException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
            }

        } while (choice != 4);
    }
}