package seedu.duke;

import java.util.ArrayList;

public class Order {

    private String foodName;
    private int foodIndex;
    private int quantity;
    private double costOfOrder;
    private static ArrayList<String> menuList = Menu.FOODLIST;
    private static ArrayList<Double> priceList = Menu.PRICELIST;

    public Order(int foodIndex, int quantity) {
        this.foodIndex = foodIndex;
        this.foodName = menuList.get(foodIndex);
        this.quantity = quantity;
        this.costOfOrder = quantity * priceList.get(foodIndex);
    }

    public void setQuantity(int quantityToSet) {
        this.quantity = quantityToSet;
        this.costOfOrder = quantityToSet * priceList.get(foodIndex);
    }

    public int getQuantity() {
        return quantity;
    }

    public double getCost() {
        return costOfOrder;
    }

    public String toString() {
        return foodName + " | Quantity = " + quantity + " | Cost = $" + String.format("%.2f", costOfOrder);
    }
}
