package utils;

import stream.models.RandomNumbers;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomNumbersFactory {
    
    private static final Random random = new Random();

    public static int generateRandomNumber() {
        return random.nextInt(201) - 100;
    }

    public static int generateRandomNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public static RandomNumbers createRandomNumbers() {
        int randomSize = random.nextInt(100) + 50; // from 50 to 149
        return new RandomNumbers(randomSize);
    }

    public static RandomNumbers createRandomNumbers(int size) {
        return new RandomNumbers(size);
    }

    public static int[] generateRandomArray(int size) {
        return IntStream.range(0, size)
                .map(i -> generateRandomNumber())
                .toArray();
    }

    public static int[] generateRandomArray(int size, int min, int max) {
        return IntStream.range(0, size)
                .map(i -> generateRandomNumber(min, max))
                .toArray();
    }
}

