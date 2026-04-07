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

    void linearSearch(String searchId) {
        boolean found = false;

        for (PassengerBogie b : bogies) {
            if (b.id.equalsIgnoreCase(searchId)) {
                System.out.println("Bogie found:");
                b.display();
                found = true;
                break;
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
            System.out.println("3 Search Bogie (Linear Search)");
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
                    train.linearSearch(search);
                    break;
            }

        } while (choice != 4);
    }
}