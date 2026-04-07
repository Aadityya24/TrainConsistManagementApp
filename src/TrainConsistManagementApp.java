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
    LinkedHashSet<String> bogieIds = new LinkedHashSet<>();
    ArrayList<PassengerBogie> bogies = new ArrayList<>();

    void addBogie(PassengerBogie b) {
        if (bogieIds.contains(b.id)) {
            System.out.println("Duplicate ID not allowed");
        } else {
            bogieIds.add(b.id);
            bogies.add(b);
            System.out.println("Bogie added");
        }
    }

    void removeBogie(int index) {
        if (index >= 0 && index < bogies.size()) {
            bogieIds.remove(bogies.get(index).id);
            bogies.remove(index);
            System.out.println("Bogie removed");
        } else {
            System.out.println("Invalid index");
        }
    }

    void searchBogie(String id) {
        if (bogieIds.contains(id))
            System.out.println("Bogie exists");
        else
            System.out.println("Bogie not found");
    }

    void displayAll() {
        for (PassengerBogie b : bogies) {
            b.display();
        }
    }

    void displayInOrder() {
        System.out.println("Bogie IDs in insertion order:");
        for (String id : bogieIds) {
            System.out.println(id);
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
            System.out.println("2 Remove Bogie");
            System.out.println("3 Search Bogie");
            System.out.println("4 Display All");
            System.out.println("5 Display Insertion Order");
            System.out.println("6 Exit");

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
                    System.out.print("Enter index: ");
                    int index = sc.nextInt();
                    train.removeBogie(index);
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Enter ID to search: ");
                    String search = sc.nextLine();
                    train.searchBogie(search);
                    break;

                case 4:
                    train.displayAll();
                    break;

                case 5:
                    train.displayInOrder();
                    break;
            }

        } while (choice != 6);
    }
}