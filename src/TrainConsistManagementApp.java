import java.util.*;

class InvalidCargoException extends Exception {
    InvalidCargoException(String msg) {
        super(msg);
    }
}

class GoodsBogie {
    String id;
    String shape;
    String cargo;

    GoodsBogie(String id, String shape) {
        this.id = id;
        this.shape = shape;
    }

    void assignCargo(String cargo) throws InvalidCargoException {
        if (shape.equalsIgnoreCase("Cylindrical") && !cargo.equalsIgnoreCase("Oil")) {
            throw new InvalidCargoException("Cylindrical bogie can carry only Oil");
        }
        if (shape.equalsIgnoreCase("Rectangular") && !cargo.equalsIgnoreCase("Coal")) {
            throw new InvalidCargoException("Rectangular bogie can carry only Coal");
        }
        this.cargo = cargo;
    }

    void display() {
        System.out.println(id + " | " + shape + " | " + cargo);
    }
}

class Train {
    ArrayList<GoodsBogie> goodsBogies = new ArrayList<>();

    void addBogie(GoodsBogie b) {
        goodsBogies.add(b);
        System.out.println("Bogie added");
    }

    void displayAll() {
        for (GoodsBogie b : goodsBogies) {
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
            System.out.println("\n1 Add Goods Bogie");
            System.out.println("2 Assign Cargo");
            System.out.println("3 Display All");
            System.out.println("4 Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter shape (Cylindrical/Rectangular): ");
                    String shape = sc.nextLine();
                    train.addBogie(new GoodsBogie(id, shape));
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter Bogie ID: ");
                    String bid = sc.nextLine();
                    System.out.print("Enter Cargo: ");
                    String cargo = sc.nextLine();

                    for (GoodsBogie b : train.goodsBogies) {
                        if (b.id.equalsIgnoreCase(bid)) {
                            try {
                                b.assignCargo(cargo);
                                System.out.println("Cargo assigned successfully");
                            } catch (InvalidCargoException e) {
                                System.out.println("Error: " + e.getMessage());
                            } finally {
                                System.out.println("Assignment attempted");
                            }
                        }
                    }
                    break;

                case 3:
                    train.displayAll();
                    break;
            }

        } while (choice != 4);
    }
}