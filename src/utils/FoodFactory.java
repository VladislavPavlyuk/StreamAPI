package utils;

import stream.models.Foods;
import stream.models.Food;

import java.util.*;
import java.util.stream.Collectors;

public class FoodFactory {
    
    private static final Map<String, List<String>> productsByCategory = new HashMap<>();
    
    static {
        productsByCategory.put("Dairy", Arrays.asList("Milk", "Kefir", "Cottage Cheese", "Yogurt", "Sour Cream", "Cheese", "Butter"));
        productsByCategory.put("Bakery", Arrays.asList("Bread", "Bun", "Loaf", "Baguette", "Croissant", "Pie", "Donut"));
        productsByCategory.put("Groceries", Arrays.asList("Rice", "Buckwheat", "Pasta", "Oatmeal", "Semolina", "Pearl Barley", "Sugar", "Salt", "Pepper", "Flour", "Yeast"));
        productsByCategory.put("Meat", Arrays.asList("Meat", "Sausage", "Sausages", "Ham", "Bacon", "Lard", "Dumplings"));
        productsByCategory.put("Fish", Arrays.asList("Fish", "Shrimp", "Squid", "Caviar", "Crab", "Mussels", "Tuna"));
        productsByCategory.put("Poultry", Arrays.asList("Chicken", "Turkey", "Duck", "Goose", "Eggs"));
        productsByCategory.put("Vegetables", Arrays.asList("Potato", "Carrot", "Onion", "Tomato", "Cucumber", "Cabbage", "Pepper", "Eggplant", "Zucchini", "Pumpkin"));
        productsByCategory.put("Fruits", Arrays.asList("Apple", "Bananas", "Oranges", "Pears", "Grapes", "Strawberry", "Raspberry", "Blueberry", "Cherry", "Plum"));
        productsByCategory.put("Canned", Arrays.asList("Stewed Meat", "Canned Fish", "Canned Vegetables", "Canned Fruits", "Condensed Milk", "Pate"));
        productsByCategory.put("Sweets", Arrays.asList("Honey", "Nuts", "Raisins", "Prunes", "Dates", "Figs", "Chocolate", "Cookies", "Candy"));
        productsByCategory.put("Beverages", Arrays.asList("Tea", "Coffee", "Juice", "Water", "Lemonade", "Compote", "Kvass", "Fruit Drink", "Soda"));
    }
    
    private static final Random random = new Random();

    public static List<Food> generateProducts(int size) {
        Set<Food> productsSet = new LinkedHashSet<>();
        List<String> categories = new ArrayList<>(productsByCategory.keySet());
        
        // Calculate total unique products available
        int totalUniqueProducts = productsByCategory.values().stream()
                .mapToInt(List::size)
                .sum();
        
        // Limit size to available unique products
        int actualSize = Math.min(size, totalUniqueProducts);
        
        // Collect all unique products using Stream API
        List<Food> allUniqueProducts = categories.stream()
                .flatMap(category -> productsByCategory.get(category).stream()
                        .map(productName -> new Food(productName, category)))
                .collect(Collectors.toList());
        
        // Shuffle to randomize order
        Collections.shuffle(allUniqueProducts);
        
        // Take first 'actualSize' unique products using Stream API
        allUniqueProducts.stream()
                .limit(actualSize)
                .forEach(productsSet::add);
        
        return new ArrayList<>(productsSet);
    }

    public static Foods createFood(int size) {
        return new Foods(generateProducts(size));
    }

    public static Foods createFood() {
        return createFood(50);
    }

    public static String getRandomProduct() {
        List<String> allCategories = new ArrayList<>(productsByCategory.keySet());
        String randomCategory = allCategories.get(random.nextInt(allCategories.size()));
        List<String> categoryProducts = productsByCategory.get(randomCategory);
        return categoryProducts.get(random.nextInt(categoryProducts.size()));
    }

    public String createProduct() {
        return getRandomProduct();
    }
}
