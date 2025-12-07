package data.iFood;
/*
* Taps
* Work on aggregation
* */
import java.util.ArrayList;

public class Meal {
    private ArrayList<FoodItem> items;

    public Meal() {
        items = new ArrayList<>();
    }

    public void addItem(FoodItem item) {
        items.add(item);
    }

    public double getCarbonFootprint() {
        double total = 0;
        for (FoodItem item : items) {
            total += item.calculateCarbonFootprint();
        }
        return total;
    }

    public double getWaterUsage() {
        double total = 0;
        for (FoodItem item : items) {
            total += item.calculateWaterUsage();
        }
        return total;
    }

    public void displayMealImpact() {
        System.out.println("\nMeals");
        for (FoodItem item : items) {
            System.out.println("- " + item.getName());
        }
        System.out.println("\nTotal Carbon Footprint: " + getCarbonFootprint() + " kg CO₂");
        System.out.println("Total Water Usage: " + getWaterUsage() + " L");
    }
}