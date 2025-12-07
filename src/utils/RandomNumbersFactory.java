package utils;

import stream.models.RandomNumbers;

import java.util.Random;

public class RandomNumbersFactory {
    
    private static final Random random = new Random();
    
    /**
     * Generates a random number in range from -100 to 100
     * @return random number
     */
    public static int generateRandomNumber() {
        return random.nextInt(201) - 100;
    }
    
    /**
     * Generates a random number in the specified range
     * @param min minimum value
     * @param max maximum value
     * @return random number
     */
    public static int generateRandomNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
    
    /**
     * Creates a RandomNumbers instance with random maxSize
     * @return RandomNumbers instance
     */
    public static RandomNumbers createRandomNumbers() {
        int randomSize = random.nextInt(100) + 50; // from 50 to 149
        return new RandomNumbers(randomSize);
    }
    
    /**
     * Creates a RandomNumbers instance with specified size
     * @param size collection size
     * @return RandomNumbers instance
     */
    public static RandomNumbers createRandomNumbers(int size) {
        return new RandomNumbers(size);
    }
    
    /**
     * Generates an array of random numbers of specified size
     * @param size array size
     * @return array of random numbers from -100 to 100
     */
    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = generateRandomNumber();
        }
        return array;
    }
    
    /**
     * Generates an array of random numbers of specified size in the specified range
     * @param size array size
     * @param min minimum value
     * @param max maximum value
     * @return array of random numbers
     */
    public static int[] generateRandomArray(int size, int min, int max) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = generateRandomNumber(min, max);
        }
        return array;
    }
}

