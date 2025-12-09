package data.iFood;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;

public class EnvironmentalImpactCalculator extends JFrame {
    private Meal currentMeal;

    // UI Components
    private JLabel carbonLabel, waterLabel;
    private JList<String> foodList;
    private JPanel mealPanel;

    // Color palette storage for later use
    private final Color BG_COLOR = new Color(245, 247, 250);
    private final Color CARD_COLOR = new Color(255, 255, 255);
    private final Color TEXT_COLOR = new Color(52, 58, 64);
    private final Color TEXT_SECONDARY = new Color(108, 117, 125);
    private final Color ACCENT_RED = new Color(220, 53, 69);
    private final Color ACCENT_BLUE = new Color(0, 123, 255);
    private final Color BORDER_COLOR = new Color(222, 226, 230);

    public EnvironmentalImpactCalculator() {
        currentMeal = new Meal("My Meal");
        setupUI();
        loadFoods();
    }

    private void setupUI() {
        setTitle("iFood");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(BG_COLOR);

        // Main layout
        JPanel mainPanel = new JPanel(new GridLayout(1, 3, 15, 0));
        mainPanel.setBackground(BG_COLOR);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        mainPanel.add(createFoodMenu());
        mainPanel.add(createCurrentMeal());
        mainPanel.add(createImpactPanel());

        add(mainPanel);
    }

    private JPanel createFoodMenu() {
        JPanel panel = new JPanel(new BorderLayout(0, 10));
        panel.setBackground(CARD_COLOR);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER_COLOR, 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)));


        JLabel title = new JLabel("Food Menu");
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setForeground(TEXT_COLOR);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // List
        DefaultListModel<String> model = new DefaultListModel<>();
        foodList = new JList<>(model);
        foodList.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        foodList.setBackground(new Color(248, 249, 250));
        foodList.setSelectionBackground(new Color(0, 123, 255, 20));
        foodList.setSelectionForeground(TEXT_COLOR);

        JScrollPane scrollPane = new JScrollPane(foodList);
        scrollPane.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 1));

        JButton addButton = new JButton("Add to Selection");
        addButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        addButton.setForeground(Color.DARK_GRAY);
        addButton.setFocusPainted(false);
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addButton.addActionListener(e -> addSelectedFood());

        panel.add(title, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createCurrentMeal() {
        JPanel panel = new JPanel(new BorderLayout(0, 10));
        panel.setBackground(CARD_COLOR);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER_COLOR, 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        // Title and clear
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(CARD_COLOR);

        JLabel title = new JLabel("Meal Selection");
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setForeground(TEXT_COLOR);

        JButton clearButton = createStyledButton("Clear All", BG_COLOR);
        clearButton.setForeground(Color.RED);
        clearButton.addActionListener(e -> clearMeal());

        titlePanel.add(title, BorderLayout.WEST);
        titlePanel.add(clearButton, BorderLayout.EAST);

        // Meal items panel
        mealPanel = new JPanel();
        mealPanel.setLayout(new BoxLayout(mealPanel, BoxLayout.Y_AXIS));
        mealPanel.setBackground(new Color(248, 249, 250));

        JScrollPane scrollPane = new JScrollPane(mealPanel);
        scrollPane.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 1));
        scrollPane.getViewport().setBackground(new Color(248, 249, 250));

        panel.add(titlePanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createImpactPanel() {
        JPanel panel = new JPanel(new BorderLayout(0, 15));
        panel.setBackground(CARD_COLOR);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER_COLOR, 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        JLabel title = new JLabel("Environmental Impact");
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setForeground(TEXT_COLOR);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        // Impact cards
        JPanel impactPanel = new JPanel(new GridLayout(2, 1, 0, 15));
        impactPanel.setBackground(CARD_COLOR);

        // Carbon card
        JPanel carbonCard = createImpactCard("Carbon Footprint", ACCENT_RED);
        carbonLabel = (JLabel) ((JPanel) carbonCard.getComponent(1)).getComponent(0);

        // Water card
        JPanel waterCard = createImpactCard("Water Usage", ACCENT_BLUE);
        waterLabel = (JLabel) ((JPanel) waterCard.getComponent(1)).getComponent(0);

        impactPanel.add(carbonCard);
        impactPanel.add(waterCard);

        panel.add(title, BorderLayout.NORTH);
        panel.add(impactPanel, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createImpactCard(String title, Color color) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(new Color(color.getRed(), color.getGreen(), color.getBlue(), 10));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(color.getRed(), color.getGreen(), color.getBlue(), 30), 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titleLabel.setForeground(color);

        JLabel valueLabel = new JLabel("0.0");
        valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        valueLabel.setForeground(color);

        JLabel unitLabel = new JLabel(title.contains("Carbon") ? "kg CO₂" : "Liters");
        unitLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        unitLabel.setForeground(TEXT_SECONDARY);
        unitLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));

        JPanel valuePanel = new JPanel(new BorderLayout());
        valuePanel.setBackground(new Color(0, 0, 0, 0));
        valuePanel.add(valueLabel, BorderLayout.NORTH);
        valuePanel.add(unitLabel, BorderLayout.CENTER);

        card.add(titleLabel, BorderLayout.NORTH);
        card.add(valuePanel, BorderLayout.CENTER);

        return card;
    }

    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        button.setForeground(Color.RED);
        button.setBackground(bgColor);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));

        return button;
    }

    private void loadFoods() {
        DefaultListModel<String> model = (DefaultListModel<String>) foodList.getModel();
        model.clear();

        List<FoodItem> foods = Menu.getAllFoods();
        for (FoodItem food : foods) {
            model.addElement(food.getName());
        }
    }

    private void addSelectedFood() {
        int selectedIndex = foodList.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select a food first");
            return;
        }

        List<FoodItem> foods = Menu.getAllFoods();
        FoodItem selectedFood = foods.get(selectedIndex);

        String weightStr = JOptionPane.showInputDialog(this,
                "Weight in grams for " + selectedFood.getName() + ":",
                "100");

        if (weightStr == null || weightStr.trim().isEmpty()) return;

        try {
            double weight = Double.parseDouble(weightStr);
            if (weight <= 0) {
                JOptionPane.showMessageDialog(this, "Weight must be positive");
                return;
            }

            FoodItem foodCopy = new FoodItem(
                    selectedFood.getName(),
                    selectedFood.getCarbonPerKg(),
                    selectedFood.getWaterPerKg()
            );
            foodCopy.setWeightInGrams(weight);

            currentMeal.addItem(foodCopy);
            updateMealDisplay();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number");
        }
    }

    private void updateMealDisplay() {
        mealPanel.removeAll();

        if (currentMeal.getItemCount() == 0) {
            JLabel emptyLabel = new JLabel("<html><div style='text-align: center; color: #6c757d;'>" +
                    "<small>Add foods from the menu</small>" +
                    "</div></html>");
            emptyLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            emptyLabel.setHorizontalAlignment(SwingConstants.CENTER);
            mealPanel.add(emptyLabel);
        } else {
            for (FoodItem item : currentMeal.getItems()) {
                mealPanel.add(createMealItem(item));
            }
        }

        updateImpactStats();
        mealPanel.revalidate();
        mealPanel.repaint();
    }

    private JPanel createMealItem(FoodItem item) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(CARD_COLOR);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, BORDER_COLOR),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        // Food info
        JLabel nameLabel = new JLabel(item.getName());
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        nameLabel.setForeground(TEXT_COLOR);

        DecimalFormat df = new DecimalFormat("#.##");
        JLabel weightLabel = new JLabel(df.format(item.getWeightInGrams()) + "g");
        weightLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        weightLabel.setForeground(TEXT_SECONDARY);

        JPanel infoPanel = new JPanel(new BorderLayout());
        infoPanel.setBackground(CARD_COLOR);
        infoPanel.add(nameLabel, BorderLayout.NORTH);
        infoPanel.add(weightLabel, BorderLayout.CENTER);

        // Remove selected food
        JButton removeButton = createStyledButton("X", Color.red);
        removeButton.addActionListener(e -> {
            currentMeal.removeItem(item);
            updateMealDisplay();
        });

        panel.add(infoPanel, BorderLayout.CENTER);
        panel.add(removeButton, BorderLayout.EAST);

        return panel;
    }

    private void updateImpactStats() {
        DecimalFormat df = new DecimalFormat("#.##");

        double totalCarbon = currentMeal.getTotalCarbonFootprint();
        double totalWater = currentMeal.getTotalWaterUsage();

        carbonLabel.setText(df.format(totalCarbon));
        waterLabel.setText(df.format(totalWater));
    }

    private void clearMeal() {
        int response = JOptionPane.showConfirmDialog(this,
                "Clear all items from your meal?",
                "Clear Meal Selection",
                JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            currentMeal.clear();
            updateMealDisplay();
        }
    }

    public static void main(String[] args) {
        // Set system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new EnvironmentalImpactCalculator().setVisible(true);
        });
    }
}