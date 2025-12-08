package data.iFood;

public class FoodItem {
    private String name;
    private double carbonPerKg, waterPerKg, weightInGrams;

    public FoodItem(String name, double carbonPerKg, double waterPerKg) {
        this.name = name;
        this.carbonPerKg = carbonPerKg;
        this.waterPerKg = waterPerKg;
        this.weightInGrams = 100;
    }

    // Getters
    public String getName() { return name; }
    public double getCarbonPerKg() { return carbonPerKg; }
    public double getWaterPerKg() { return waterPerKg; }
    public double getWeightInGrams() { return weightInGrams; }

    // Setters
    public void setWeightInGrams(double weight) {
        if (weight > 0) this.weightInGrams = weight;
    }

    // Carbon & Water computations
    public double calculateCarbonFootprint() {
        return carbonPerKg * (weightInGrams / 1000.0);
    }

    public double calculateWaterUsage() {
        return waterPerKg * (weightInGrams / 1000.0);
    }
}