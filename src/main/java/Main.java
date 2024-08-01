import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a list of menu items
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Burger", null, 10, "Main"));
        menuItems.add(new MenuItem("Pizza", null, 15, "Main"));
        menuItems.add(new MenuItem("Salad", null, 8, "Main"));
        menuItems.add(new MenuItem("Ice Cream", null, 6, "Dessert"));
        menuItems.add(new MenuItem("Fries", null, 5, "Side"));
        menuItems.add(new MenuItem("Soda", null, 2, "Drink"));

        // Display the menu items
        for (MenuItem menuItem : menuItems) {
            menuItem.printMenuItem();
        }

        // Order the menu items
        Order order = new Order();
        order.addOrderingItem(menuItems.get(0), 2);
        order.addOrderingItem(menuItems.get(1), 3);
        order.addOrderingItem(menuItems.get(3), 1);

        // Display the order
        order.printOrder();

        // Update the status of the order
        order.updateStatus("Preparing");
        order.removeOrderingItem(0);
        // Display the order
        order.printOrder();
    }
}
