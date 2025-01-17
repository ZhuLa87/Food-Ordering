import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private long id;
    private static long nextId = 1;
    private Date date;
    private String status;  // "Pending", "Preparing", "Ready", "Delivered"
    private int totalAmount;
    private List<MenuItem> OrderingItem;

    public Order() {
        this.id = nextId++;
        this.date = new Date();
        this.status = "Pending";
        this.totalAmount = 0;
        OrderingItem = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public List<MenuItem> getOrderingItem() {
        return OrderingItem;
    }

    public void addOrderingItem(MenuItem menuItem, int quantity) {
        if (!menuItem.isAvailable()) {
            // check if the menu item is available
            throw new IllegalArgumentException("Menu item is not available");
        }
        if (quantity <= 0) {
            // check if the quantity is valid
            throw new IllegalArgumentException("Invalid quantity");
        }
        menuItem.setQuantity(quantity);
        OrderingItem.add(menuItem);
        calculateTotalAmount();
    }

    public void removeOrderingItem(int orderItemId) {
        if (orderItemId < 0 || orderItemId >= OrderingItem.size()) {
            // check if the orderItemId is valid
            throw new IllegalArgumentException("Invalid order item ID");
        }
        OrderingItem.remove(orderItemId);
        calculateTotalAmount();
    }

    public List<MenuItem> getOrderingItems() {
        return OrderingItem;
    }

    public void updateStatus(String newStatus) {
        status = newStatus;
    }

    private void calculateTotalAmount() {
        totalAmount = 0;
        for (MenuItem item : OrderingItem) {
            totalAmount += item.getSubTotal();
        }
    }

    public void printOrder() {
        System.out.println("Order ID: " + id);
        System.out.println("Date: " + date);
        System.out.println("Status: " + status);
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("Items:");
        for (MenuItem item : OrderingItem) {
            System.out.println("  " + item.getName() + " - $" + item.getPrice() + " x " + item.getQuantity() + " = $" + item.getSubTotal());
        }
        System.out.println("##################################################");
    }
}
