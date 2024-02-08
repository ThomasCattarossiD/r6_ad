import java.time.LocalDate;

public class SimpleClass {
    public static void main(String[] args){
        new SimpleClass().add(1,2);

        DateUtils.isNowBetween(LocalDate.MIN, LocalDate.MAX);
        DateUtils.isDateBetween(LocalDate.of(2024, 1, 1), LocalDate.MIN, LocalDate.MAX, true);
    }

    /**
     * Adds firstNumber and secondNumber
     * @param firstNumber the first number
     * @param secondNumber the second number
     * @return the sum of firstNumber and secondNumber
     */
    public int add(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }

}
