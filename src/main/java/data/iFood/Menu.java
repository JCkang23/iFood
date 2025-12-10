package data.iFood;

import data.iFood.foods.*;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private static final List<FoodItem> FOODS = new ArrayList<>();
    private static final List<FoodItem> CUSTOM_FOODS = new ArrayList<>();

    static {
        // Meal Components <> Menu
        FOODS.add(new Beef());
        FOODS.add(new Chicken());
        FOODS.add(new Fish());
        FOODS.add(new Cheese());
        FOODS.add(new Eggs());
        FOODS.add(new Rice());
        FOODS.add(new Pasta());
        FOODS.add(new Bread());
        FOODS.add(new Banana());
        FOODS.add(new Orange());
        FOODS.add(new Lentil());
        FOODS.add(new Beans());
        FOODS.add(new Coffee());
        FOODS.add(new Tea());
        FOODS.add(new Yam());
    }

    public static List<FoodItem> getAllFoods() {
        List<FoodItem> allFoods = new ArrayList<>(FOODS);
        allFoods.addAll(CUSTOM_FOODS);
        return allFoods;
    }
}