public class MenuItem {
    private long id;
    private static long nextId = 1;
    private String name;
    private int price;
    private String description;
    private String type;
    private int quantity;
    private int subTotal;
    private boolean isAvailable;

    MenuItem(String name, String description, int price, String type) {
        this.id = nextId++;
        this.name = name;
        this.price = price;
        this.description = (description == null) ? "" : description;
        this.type = (type == null) ? "" : type;
        this.quantity = 0;
        this.subTotal = 0;
        this.isAvailable = true;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    private double calculateSubTotal() {
        subTotal = quantity * price;
        return subTotal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        calculateSubTotal();
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setPrice(int price) {
        if (price < 0) {
            // check if the price is valid
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            // check if the name is valid
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public void printMenuItem() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Description: " + description);
        System.out.println("Type: " + type);
        System.out.println("Quantity: " + quantity);
        System.out.println("Subtotal: " + subTotal);
        System.out.println("Available: " + isAvailable);
        System.out.println("--------------------------------------------------");
    }
}
