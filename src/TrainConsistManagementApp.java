import java.util.*;

class Bogie {
    String type;

    Bogie(String type) {
        this.type = type;
    }

    void display() {
        System.out.println(type);
    }
}

class PassengerBogie extends Bogie {
    int capacity;

    PassengerBogie(String type, int capacity) {
        super(type);
        this.capacity = capacity;
    }

    void display() {
        System.out.println(type + " | Capacity: " + capacity);
    }
}

class Train {
    ArrayList<PassengerBogie> bogies = new ArrayList<>();

    void addBogie(PassengerBogie b) {
        bogies.add(b);
        System.out.println("Bogie added");
    }

    void removeBogie(int index) {
        if (index >= 0 && index < bogies.size()) {
            bogies.remove(index);
            System.out.println("Bogie removed");
        } else {
            System.out.println("Invalid index");
        }
    }

    void searchBogie(String type) {
        boolean found = false;

        for (PassengerBogie b : bogies) {
            if (b.type.equalsIgnoreCase(type)) {
                found = true;
                break;
            }
        }

        if (found)
            System.out.println("Bogie exists");
        else
            System.out.println("Bogie not found");
    }

    void display() {
        for (int i = 0; i < bogies.size(); i++) {
            System.out.print(i + " -> ");
            bogies.get(i).display();
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
            System.out.println("4 Display");
            System.out.println("5 Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter type: ");
                    String type = sc.nextLine();
                    System.out.print("Enter capacity: ");
                    int cap = sc.nextInt();
                    train.addBogie(new PassengerBogie(type, cap));
                    break;

                case 2:
                    System.out.print("Enter index: ");
                    int index = sc.nextInt();
                    train.removeBogie(index);
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Enter type to search: ");
                    String search = sc.nextLine();
                    train.searchBogie(search);
                    break;

                case 4:
                    train.display();
                    break;
            }

        } while (choice != 5);
    }
}