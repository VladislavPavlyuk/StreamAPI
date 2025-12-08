package utils;

import stream.models.Food;
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
     * Generates a list of random food items grouped by categories
     * @param size number of products to generate
     * @return list of random food items
     */
    public static List<FoodCategory> generateProducts(int size) {
        List<FoodCategory> products = new ArrayList<>();
        List<String> categories = new ArrayList<>(productsByCategory.keySet());
        
        // Ensure products are distributed across categories
        int productsPerCategory = size / categories.size();
        int remainder = size % categories.size();
        
        for (String category : categories) {
            List<String> categoryProducts = productsByCategory.get(category);
            int count = productsPerCategory + (remainder-- > 0 ? 1 : 0);
            
            for (int i = 0; i < count && products.size() < size; i++) {
                String productName = categoryProducts.get(random.nextInt(categoryProducts.size()));
                products.add(new FoodCategory(productName, category));
            }
        }
        
        // Shuffle to randomize order
        Collections.shuffle(products);
        return products;
    }
    
    /**
     * Creates a Food instance with randomly generated products
     * @param size number of products to generate
     * @return Food instance
     */
    public static Food createFood(int size) {
        return new Food(generateProducts(size));
    }
    
    /**
     * Creates a Food instance with 50 randomly generated products
     * @return Food instance
     */
    public static Food createFood() {
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
