package utils;

import stream.models.RandomNumbers;

import java.util.Random;

public class RandomNumbersFactory {
    
    private static final Random random = new Random();
    
    /**
     * Генерирует случайное число в диапазоне от -100 до 100
     * @return случайное число
     */
    public static int generateRandomNumber() {
        return random.nextInt(201) - 100;
    }
    
    /**
     * Генерирует случайное число в заданном диапазоне
     * @param min минимальное значение
     * @param max максимальное значение
     * @return случайное число
     */
    public static int generateRandomNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
    
    /**
     * Создает экземпляр RandomNumbers со случайным maxSize
     * @return экземпляр RandomNumbers
     */
    public static RandomNumbers createRandomNumbers() {
        int randomSize = random.nextInt(100) + 50; // от 50 до 149
        return new RandomNumbers(randomSize);
    }
    
    /**
     * Создает экземпляр RandomNumbers с заданным размером
     * @param size размер коллекции
     * @return экземпляр RandomNumbers
     */
    public static RandomNumbers createRandomNumbers(int size) {
        return new RandomNumbers(size);
    }
    
    /**
     * Генерирует массив случайных чисел заданного размера
     * @param size размер массива
     * @return массив случайных чисел от -100 до 100
     */
    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = generateRandomNumber();
        }
        return array;
    }
    
    /**
     * Генерирует массив случайных чисел заданного размера в указанном диапазоне
     * @param size размер массива
     * @param min минимальное значение
     * @param max максимальное значение
     * @return массив случайных чисел
     */
    public static int[] generateRandomArray(int size, int min, int max) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = generateRandomNumber(min, max);
        }
        return array;
    }
}

