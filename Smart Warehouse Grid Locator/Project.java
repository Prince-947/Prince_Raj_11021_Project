import java.util.Scanner;

class GridItem {
    private String itemId;
    private String itemName;
    private int quantity;

    public GridItem(String itemId, String itemName, int quantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void display() {
        System.out.println(itemId + " - " + itemName + " (Qty: " + quantity + ")");
    }
}

class Warehouse {
    private GridItem[][] grid;

    public Warehouse(int rows, int columns) {
        grid = new GridItem[rows][columns];
    }

    public void addItem(int row, int col, GridItem item) {
        grid[row][col] = item;
    }

    public void searchItem(String id) {
        System.out.println("\nSearching for item ID: " + id);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] != null &&
                    grid[i][j].getItemId().equals(id)) {

                    System.out.println("Item found at Row: " + i +
                                       ", Column: " + j);

                    System.out.print("Item Details: ");
                    grid[i][j].display();
                    return;
                }
            }
        }

        System.out.println("Item not found in warehouse");
    }

    public void displayGrid() {
        System.out.println("Warehouse Layout:");

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] != null) {
                    System.out.print(grid[i][j].getItemId() + "\t");
                } else {
                    System.out.print("Empty\t");
                }
            }
            System.out.println();
        }
    }
}
public class Project {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        Warehouse warehouse = new Warehouse(rows, cols);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for item " + (i + 1));

            System.out.print("Item ID: ");
            String id = sc.next();

            System.out.print("Item Name: ");
            String name = sc.next();

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            System.out.print("Row position: ");
            int row = sc.nextInt();

            System.out.print("Column position: ");
            int col = sc.nextInt();

            warehouse.addItem(row, col, new GridItem(id, name, quantity));
        }
        warehouse.displayGrid();

        System.out.print("\nEnter item ID to search: ");
        String searchId = sc.next();
        warehouse.searchItem(searchId);
    }
}
