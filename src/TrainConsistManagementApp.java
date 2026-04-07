import java.util.*;

class Train {
    HashMap<String, Integer> bogieMap = new HashMap<>();

    void addBogie(String id, int capacity) {
        if (bogieMap.containsKey(id)) {
            System.out.println("Duplicate ID not allowed");
        } else {
            bogieMap.put(id, capacity);
            System.out.println("Bogie added");
        }
    }

    void removeBogie(String id) {
        if (bogieMap.containsKey(id)) {
            bogieMap.remove(id);
            System.out.println("Bogie removed");
        } else {
            System.out.println("Bogie not found");
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
        for (Map.Entry<String, Integer> e : bogieMap.entrySet()) {
            System.out.println(e.getKey() + " | Capacity: " + e.getValue());
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
            System.out.println("5 Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter capacity: ");
                    int cap = sc.nextInt();
                    train.addBogie(id, cap);
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter ID: ");
                    String removeId = sc.nextLine();
                    train.removeBogie(removeId);
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Enter ID: ");
                    String searchId = sc.nextLine();
                    train.searchBogie(searchId);
                    break;

                case 4:
                    train.displayAll();
                    break;
            }

        } while (choice != 5);
    }
}