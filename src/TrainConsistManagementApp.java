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

    void sortBogieNames() {
        String[] types = new String[bogies.size()];

        for (int i = 0; i < bogies.size(); i++) {
            types[i] = bogies.get(i).type;
        }

        Arrays.sort(types);

        System.out.println("Sorted Bogie Types:");
        for (String t : types) {
            System.out.println(t);
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
            System.out.println("3 Sort Bogie Names");
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
                    train.sortBogieNames();
                    break;
            }

        } while (choice != 4);
    }
}