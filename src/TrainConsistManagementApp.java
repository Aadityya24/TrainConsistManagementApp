import java.util.*;
import java.util.regex.*;
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

class Train {
    ArrayList<PassengerBogie> bogies = new ArrayList<>();
    HashMap<String, Integer> bogieMap = new HashMap<>();

    boolean validateTrainId(String trainId) {
        Pattern p = Pattern.compile("TRN-\\d{4}");
        Matcher m = p.matcher(trainId);
        return m.matches();
    }

    boolean validateCargoCode(String code) {
        Pattern p = Pattern.compile("CG-[A-Z]{3}-\\d{2}");
        Matcher m = p.matcher(code);
        return m.matches();
    }

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
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Train train = new Train();

        System.out.print("Enter Train ID: ");
        String trainId = sc.nextLine();

        if (!train.validateTrainId(trainId)) {
            System.out.println("Invalid Train ID format");
            return;
        } else {
            System.out.println("Valid Train ID");
        }

        System.out.print("Enter Cargo Code: ");
        String cargo = sc.nextLine();

        if (!train.validateCargoCode(cargo)) {
            System.out.println("Invalid Cargo Code format");
        } else {
            System.out.println("Valid Cargo Code");
        }

        int choice;

        do {
            System.out.println("\n1 Add Bogie");
            System.out.println("2 Display All");
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
                    train.displayAll();
                    break;
            }

        } while (choice != 3);
    }
}