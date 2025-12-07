package data.iFood;

/*
* Josue's implementation
* */

public class FoodItem {
    // Variable declaration
    private String name;
    private double carbonFootprintPerKg, waterUsagePerKg, weightInKg;

    // Constructor
    FoodItem(String name, double carbonFootprintPerKg, double waterUsagePerKg, double weightInKg){
        // initializing the name
        this.name = name;
        // setter methods
        setCarbonFootprintPerKg(carbonFootprintPerKg);
        setWaterUsagePerKg(waterUsagePerKg);
        setWeightInKg(weightInKg);
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getCarbonFootprintPerKg() {
        return carbonFootprintPerKg;
    }
    public double getWaterUsagePerKg() {
        return waterUsagePerKg;
    }
    public double getWeightInKg() {
        return weightInKg;
    }

    // Setters
    public void setCarbonFootprintPerKg(double carbonFootprintPerKg) {
        // Check footprint
        if (carbonFootprintPerKg >= 0) {
            this.carbonFootprintPerKg = carbonFootprintPerKg;
        } else {
            throw new IllegalArgumentException("You need to have at least no to one footprint");
        }
    }
    public void setWaterUsagePerKg(double waterUsagePerKg) {
        // Check waterusage in the food
        if (waterUsagePerKg >= 0){
            this.waterUsagePerKg = waterUsagePerKg;
        } else {
            throw new IllegalArgumentException("You need to either have no or at least one water usage");
        }
    }
    public void setWeightInKg(double weightInKg) {
        if (weightInKg >= 0) {
            this.weightInKg = weightInKg;
        } else {
            throw new IllegalArgumentException();
        }
    }

    // Setters + operations to perform
    public double calculateCarbonFootprint(){
        return carbonFootprintPerKg * this.weightInKg;
    }
    public double calculateWaterUsage() {
        return waterUsagePerKg * this.weightInKg;
    }

    @Override
    public String toString() {
        return String.format("Food Item >> %s: %.2f kg\nEnvironmental Impact | Carbon: %.1f kg CO₂, Water: %.0f L",
                name, weightInKg, calculateCarbonFootprint(), calculateWaterUsage());
    }
}