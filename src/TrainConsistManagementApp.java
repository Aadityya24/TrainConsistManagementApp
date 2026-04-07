import java.util.*;
import java.util.function.*;

class GoodsBogie {
    String id;
    String shape;
    String cargo;

    GoodsBogie(String id, String shape, String cargo) {
        this.id = id;
        this.shape = shape;
        this.cargo = cargo;
    }

    void display() {
        System.out.println(id + " | " + shape + " | " + cargo);
    }
}

class Train {
    ArrayList<GoodsBogie> goodsBogies = new ArrayList<>();

    Predicate<GoodsBogie> safetyRule = b ->
            (b.shape.equalsIgnoreCase("Cylindrical") && b.cargo.equalsIgnoreCase("Oil")) ||
                    (b.shape.equalsIgnoreCase("Rectangular") && b.cargo.equalsIgnoreCase("Coal"));

    void addGoodsBogie(GoodsBogie b) {
        if (safetyRule.test(b)) {
            goodsBogies.add(b);
            System.out.println("Goods bogie added (Safe)");
        } else {
            System.out.println("Safety violation: Invalid cargo for bogie type");
        }
    }

    void displayAll() {
        for (GoodsBogie b : goodsBogies) {
            b.display();
        }
    }

    void checkAllSafety() {
        goodsBogies.stream()
                .filter(b -> !safetyRule.test(b))
                .forEach(b -> System.out.println("Unsafe: " + b.id));
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Train train = new Train();

        int choice;

        do {
            System.out.println("\n1 Add Goods Bogie");
            System.out.println("2 Display All");
            System.out.println("3 Check Safety");
            System.out.println("4 Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter shape (Cylindrical/Rectangular): ");
                    String shape = sc.nextLine();
                    System.out.print("Enter cargo (Oil/Coal): ");
                    String cargo = sc.nextLine();

                    train.addGoodsBogie(new GoodsBogie(id, shape, cargo));
                    break;

                case 2:
                    train.displayAll();
                    break;

                case 3:
                    train.checkAllSafety();
                    break;
            }

        } while (choice != 4);
    }
}