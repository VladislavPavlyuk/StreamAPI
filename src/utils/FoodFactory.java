package utils;

import stream.models.Foods;
import stream.models.FoodCategory;

import java.util.*;

public class FoodFactory {
    
    private static final Map<String, List<String>> productsByCategory = new HashMap<>();
    
    static {
        productsByCategory.put("Молочные", Arrays.asList("Молоко", "Кефир", "Творог", "Йогурт", "Сметана", "Сыр", "Масло"));
        productsByCategory.put("Хлебобулочные", Arrays.asList("Хлеб", "Булочка", "Батон", "Багет", "Круассан", "Пирог", "Пончик"));
        productsByCategory.put("Бакалея", Arrays.asList("Рис", "Гречка", "Макароны", "Овсянка", "Манка", "Перловка", "Сахар", "Соль", "Перец", "Мука", "Дрожжи"));
        productsByCategory.put("Мясные", Arrays.asList("Мясо", "Колбаса", "Сосиски", "Ветчина", "Бекон", "Сало", "Пельмени"));
        productsByCategory.put("Рыба", Arrays.asList("Рыба", "Креветки", "Кальмары", "Икра", "Краб", "Мидии", "Тунец"));
        productsByCategory.put("Птица", Arrays.asList("Курица", "Индейка", "Утка", "Гусь", "Яйца"));
        productsByCategory.put("Овощи", Arrays.asList("Картофель", "Морковь", "Лук", "Помидор", "Огурец", "Капуста", "Перец", "Баклажан", "Кабачок", "Тыква"));
        productsByCategory.put("Фрукты", Arrays.asList("Яблоко", "Бананы", "Апельсины", "Груши", "Виноград", "Клубника", "Малина", "Черника", "Вишня", "Слива"));
        productsByCategory.put("Консервы", Arrays.asList("Тушенка", "Рыбные консервы", "Овощные консервы", "Фруктовые консервы", "Сгущенка", "Паштет"));
        productsByCategory.put("Сладости", Arrays.asList("Мед", "Орехи", "Изюм", "Чернослив", "Финики", "Инжир", "Шоколад", "Печенье", "Конфеты"));
        productsByCategory.put("Напитки", Arrays.asList("Чай", "Кофе", "Сок", "Вода", "Лимонад", "Компот", "Квас", "Морс", "Газировка"));
    }
    
    private static final Random random = new Random();
    
    /**
     * Generates a list of random food items grouped by categories without duplicates
     * @param size number of products to generate
     * @return list of random food items
     */
    public static List<FoodCategory> generateProducts(int size) {
        Set<FoodCategory> productsSet = new LinkedHashSet<>();
        List<String> categories = new ArrayList<>(productsByCategory.keySet());
        
        // Calculate total unique products available
        int totalUniqueProducts = productsByCategory.values().stream()
                .mapToInt(List::size)
                .sum();
        
        // Limit size to available unique products
        int actualSize = Math.min(size, totalUniqueProducts);
        
        // Collect all unique products
        List<FoodCategory> allUniqueProducts = new ArrayList<>();
        for (String category : categories) {
            List<String> categoryProducts = productsByCategory.get(category);
            for (String productName : categoryProducts) {
                allUniqueProducts.add(new FoodCategory(productName, category));
            }
        }
        
        // Shuffle to randomize order
        Collections.shuffle(allUniqueProducts);
        
        // Take first 'actualSize' unique products
        for (int i = 0; i < actualSize && i < allUniqueProducts.size(); i++) {
            productsSet.add(allUniqueProducts.get(i));
        }
        
        return new ArrayList<>(productsSet);
    }
    
    /**
     * Creates a Foods instance with randomly generated products
     * @param size number of products to generate
     * @return Foods instance
     */
    public static Foods createFood(int size) {
        return new Foods(generateProducts(size));
    }
    
    /**
     * Creates a Foods instance with 50 randomly generated products
     * @return Foods instance
     */
    public static Foods createFood() {
        return createFood(50);
    }
    
    /**
     * Returns a random product name from all categories
     * @return random product name
     */
    public static String getRandomProduct() {
        List<String> allCategories = new ArrayList<>(productsByCategory.keySet());
        String randomCategory = allCategories.get(random.nextInt(allCategories.size()));
        List<String> categoryProducts = productsByCategory.get(randomCategory);
        return categoryProducts.get(random.nextInt(categoryProducts.size()));
    }
    
    /**
     * Returns a random product name from all categories (non-static method)
     * @return random product name
     */
    public String createProduct() {
        return getRandomProduct();
    }
}
