import java.util.List;
import java.util.Scanner;

public class Main {


    public static boolean isDigit(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static boolean isRoman(String[] array) {
        for (String i : array) {
            if (i.contains("I") || i.contains("V") || i.contains("X")) {
                return true;
            }
        } return false;
    }


    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<Roman> romanNumerals = Roman.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            Roman currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }



    public static void main(String[] args) throws Exception {

        String input;
        String[] array;
        int firstNumber = 0;
        int secondNumber = 0;
        char operator = 0;
        int sum;
        Roman roman = null;


        System.out.println("Please enter numbers");
        Scanner scanner = new Scanner(System.in);



        input = scanner.nextLine();
        array = input.split(" ");


        if (isDigit(array[0]) && isDigit(array[2])) {
            firstNumber = Integer.parseInt(array[0]);
            operator = array[1].charAt(0);
            secondNumber = Integer.parseInt(array[2]);
        } else if (Main.isRoman(array)){
            operator = array[1].charAt(0);
            firstNumber = roman.valueOf(array[0]).ordinal() + 1;
            secondNumber = roman.valueOf(array[2]).ordinal() + 1;
        } else {
            throw new Exception("Using different number systems");
        }



        switch (operator) {
            case '+':
                sum = firstNumber + secondNumber;
                break;
            case '-':
                sum = firstNumber - secondNumber;
                break;
            case '*':
                sum = firstNumber * secondNumber;
                break;
            case '/':
                sum = firstNumber / secondNumber;
                break;
            default:
                throw new ArithmeticException("Wrong operator");
        }

        if (isRoman(array)) {
            System.out.println(Main.arabicToRoman(sum));
        } else System.out.println(sum);

    }
}
