package utils;

import stream.models.Food;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FoodFactory {
    
    private static final List<String> productTemplates = Arrays.asList(
            "Молоко", "Хлеб", "Сыр", "Яблоко", "Кефир", "Масло",
            "Творог", "Йогурт", "Сметана", "Колбаса", "Мясо", "Рыба", "Курица",
            "Картофель", "Морковь", "Лук", "Помидор", "Огурец", "Капуста",
            "Бананы", "Апельсины", "Груши", "Виноград", "Клубника", "Малина",
            "Рис", "Гречка", "Макароны", "Овсянка", "Манка", "Перловка",
            "Сахар", "Соль", "Перец", "Мука", "Дрожжи", "Яйца",
            "Мед", "Орехи", "Изюм", "Чернослив", "Финики", "Инжир",
            "Чай", "Кофе", "Сок", "Вода", "Лимонад", "Компот", "Квас"
    );
    
    private static final Random random = new Random();
    
    /**
     * Generates a list of random products
     * @param size number of products to generate
     * @return list of random products
     */
    public static List<String> generateProducts(int size) {
        List<String> products = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            products.add(productTemplates.get(random.nextInt(productTemplates.size())));
        }
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
     * Returns a random product name from the templates
     * @return random product name
     */
    public static String getRandomProduct() {
        return productTemplates.get(random.nextInt(productTemplates.size()));
    }
    
    /**
     * Returns a random product name from the templates (non-static method)
     * @return random product name
     */
    public String createProduct() {
        return getRandomProduct();
    }
}

