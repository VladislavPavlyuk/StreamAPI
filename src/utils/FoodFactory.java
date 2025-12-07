package utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FoodFactory {
    
    private static final List<String> products = Arrays.asList(
            "Молоко", "Хлеб", "Сыр", "Яблоко", "Молоко", "Кефир", "Масло",
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
     * Returns a random product name from the set
     * @return random product name
     */
    public static String getRandomProduct() {
        return products.get(random.nextInt(products.size()));
    }
    
    /**
     * Returns a random product name from the set (non-static method)
     * @return random product name
     */
    public String createProduct() {
        return getRandomProduct();
    }
}

