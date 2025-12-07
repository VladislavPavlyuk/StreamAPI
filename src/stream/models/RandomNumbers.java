package stream.models;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbers {
    int maxSize;

    public RandomNumbers(int maxSize) {
        this.maxSize = maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
    public int getMaxSize() {
        return maxSize;
    }

    Random random = new Random();

    int[] numbers = IntStream.generate(() -> random.nextInt(201) - 100)
            .limit(100)
            .toArray();

    long positiveCount = IntStream.of(numbers).filter(n -> n > 0).count();
    long negativeCount = IntStream.of(numbers).filter(n -> n < 0).count();
    long twoDigitCount = IntStream.of(numbers).filter(n -> (n >= 10 && n < 100) || (n <= -10 && n > -100)).count();
    long mirroredCount = IntStream.of(numbers).filter(RandomNumbers::isMirrored).count();

        public void print() {
            System.out.println("maxSize : " + getMaxSize());
            for (int i = 0; i < numbers.length; i++) {
                System.out.println("number "+ i + " : " + numbers[i] + "  ");
            }
            System.out.println("Positive count: " + positiveCount);
            System.out.println("Negative count: " + negativeCount);
            System.out.println("Two-digit count: " + twoDigitCount);
            
            String mirroredNumbers = IntStream.of(numbers)
                    .filter(RandomNumbers::isMirrored)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("Mirrored numbers count: " + mirroredCount + " (" + mirroredNumbers + ")");
        }

    private static boolean isMirrored(int number) {
        String str = String.valueOf(Math.abs(number));
        return str.length() > 1 && new StringBuilder(str).reverse().toString().equals(str);
    }
}

