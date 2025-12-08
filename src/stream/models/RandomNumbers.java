package stream.models;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbers {
    int maxSize;

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
    public int getMaxSize() {
        return maxSize;
    }

    Random random = new Random();
    int[] numbers;
    long positiveCount;
    long negativeCount;
    long twoDigitCount;
    long mirroredCount;

    public RandomNumbers(int maxSize) {
        this.maxSize = maxSize;
        this.numbers = IntStream.generate(() -> random.nextInt(20001) - 9999)
                .limit(maxSize)
                .toArray();

        this.positiveCount = IntStream.of(numbers).filter(n -> n > 0).count();
        this.negativeCount = IntStream.of(numbers).filter(n -> n < 0).count();
        this.twoDigitCount = IntStream.of(numbers).filter(n -> (n >= 10 && n < 100) || (n <= -10 && n > -100)).count();
        this.mirroredCount = IntStream.of(numbers).filter(RandomNumbers::isMirrored).count();
    }

    public void print() {
            System.out.println("maxSize : " + getMaxSize());
            for (int i = 0; i < numbers.length; i++) {

                System.out.println("number "+ i + " : " + numbers[i] + "  ");
            }
            System.out.println("\tPositive count: " + positiveCount);
            System.out.println("\tNegative count: " + negativeCount);
            System.out.println("\tTwo-digit count: " + twoDigitCount);
            
            String mirroredNumbers = IntStream.of(numbers)
                    .filter(RandomNumbers::isMirrored)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("\tMirrored numbers count: " + mirroredCount + " (" + mirroredNumbers + ")");
        }

    private static boolean isMirrored(int number) {
        String str = String.valueOf(Math.abs(number));
        return str.length() > 1 && new StringBuilder(str).reverse().toString().equals(str);
    }
}

