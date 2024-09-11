import stream.models.Food;
import stream.models.RandomNumbers;

public class Main {
    public static void main(String[] args) {

        RandomNumbers randomNumbers = new RandomNumbers(100);
        randomNumbers.print();

        Food food = new Food();
        food.showAll();
        food.showAllLessFive();
        food.showAllStaredOn();
        food.showAllRepeating();
        food.showAllMilk();
    }
}