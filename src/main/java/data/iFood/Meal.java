package data.iFood;

import java.util.ArrayList;
import java.util.List;
/*
 * This class demonstrates aggregation.
 * A Meal is an object that contains (aggregates) multiple FoodItem objects.
 */

public class Meal {
    private String name;
    private List<FoodItem> items;

    public Meal(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    // adding and removing from meal list
    public void addItem(FoodItem item) {
        items.add(item);
    }

    public void removeItem(FoodItem item) {
        items.remove(item);
    }

    public void clear() {
        items.clear();
    }

    public List<FoodItem> getItems() {
        return new ArrayList<>(items);
    }

    public int getItemCount() {
        return items.size();
    }

    // calculates the total carbon footprint of the meal by summing the carbon footprint of every food item
    public double getTotalCarbonFootprint() {
        double total = 0.0;
        for (FoodItem item : items) {
            total += item.calculateCarbonFootprint();
        }
        return total;
    }

    // calculates the total water usage of the meal by summing the water usage of every food item.

    public double getTotalWaterUsage() {
        double total = 0.0;
        for (FoodItem item : items) {
            total += item.calculateWaterUsage();
        }
        return total;
    }

}