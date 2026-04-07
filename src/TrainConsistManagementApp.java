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
        System.out.println(id + " | " + type + " | Capacity: " + capacity);
    }
}

class Train {
    ArrayList<PassengerBogie> bogies = new ArrayList<>();
    HashSet<String> bogieIds = new HashSet<>();

    void addBogie(PassengerBogie b) {
        if (bogieIds.contains(b.id)) {
            System.out.println("Duplicate ID not allowed");
        } else {
            bogies.add(b);
            bogieIds.add(b.id);
            System.out.println("Bogie added");
        }
    }

    void display() {
        for (PassengerBogie b : bogies) {
            b.display();
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
            System.out.println("2 Display");
            System.out.println("3 Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter Bogie ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter type: ");
                    String type = sc.nextLine();
                    System.out.print("Enter capacity: ");
                    int cap = sc.nextInt();

                    train.addBogie(new PassengerBogie(id, type, cap));
                    break;

                case 2:
                    train.display();
                    break;
            }

        } while (choice != 3);
    }
}