import java.util.*;

class GridItem {
    String id, name;
    int quantity;

    GridItem(String id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    void display() {
        System.out.println(id + " - " + name + " (Qty: " + quantity + ")");
    }
}

class Warehouse {
    GridItem[][] grid;

    Warehouse(int rows, int cols) {
        grid = new GridItem[rows][cols];
    }

    void addItem(int row, int col, GridItem item) {
        grid[row][col] = item;
    }

    void searchItem(String id) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != null && grid[i][j].id.equals(id)) {
                    System.out.println("Item found at Row: " + i + ", Column: " + j);
                    System.out.print("Item Details: ");
                    grid[i][j].display();
                    return;
                }
            }
        }
        System.out.println("Item not found in warehouse");
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
            int qty = sc.nextInt();

            System.out.print("Row position: ");
            int row = sc.nextInt();

            System.out.print("Column position: ");
            int col = sc.nextInt();

            warehouse.addItem(row, col, new GridItem(id, name, qty));
        }

        System.out.print("Enter item ID to search: ");
        String searchId = sc.next();

        warehouse.searchItem(searchId);
    }
}