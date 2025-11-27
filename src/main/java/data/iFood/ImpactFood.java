package data.iFood;
import java.util.Scanner;
/*
* Akuah's part
*
* Work on the feature of the main class
* */

public class ImpactFood {
    public static void main(String[] args) {
        // calling the addFood method for UX
        addFood();
    }

    // testing abstract class with an interactive user interface
    public static void addFood() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Food Choice Tracker");

        System.out.print("Enter food name: ");
        String name = sc.nextLine();

        System.out.print("Enter carbon footprint per kg: ");
        double carbon = sc.nextDouble();

        System.out.print("Enter water usage per kg: ");
        double water = sc.nextDouble();

        System.out.print("Enter food weight in kg: ");
        double weight = sc.nextDouble();

        /* other meal option
        * this will allow the user to enter/track a new meal beyond the predefined ones
        * it will automatically follow the structure of the predefined ones
        * */
        FoodItem otherMeal = new FoodItem(name, carbon, water, weight);

        // Displaying the result

        System.out.println("\nMain Meals\n\n");
        // Hard coded values
        // First object
        Beef beef = new Beef();
        beef.setWeightInKg(0.5);
        System.out.println(beef + "\n");

        // Second Object
        Lentil lentils = new Lentil();
        lentils.setWeightInKg(0.3);
        System.out.println(lentils + "\n");

        System.out.println("\nOther Meals\n");
        System.out.println(otherMeal);

        sc.close();
    }
}