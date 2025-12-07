package utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FoodFactory {
    
    private static final List<String> products = Arrays.asList(
            "Молоко", "Хлеб", "Сыр", "Яблоко", "Молоко", "Кефир", "Масло"
    );
    
    private static final Random random = new Random();
    
    /**
     * Возвращает случайное название продукта из набора
     * @return случайное название продукта
     */
    public static String getRandomProduct() {
        return products.get(random.nextInt(products.size()));
    }
    
    /**
     * Возвращает случайное название продукта из набора (нестатический метод)
     * @return случайное название продукта
     */
    public String createProduct() {
        return getRandomProduct();
    }
}

