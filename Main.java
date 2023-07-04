import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числовое выражение между двумя числами:");
        String expression = scanner.nextLine();
        System.out.println(calc(expression));
    }

    public static String calc(String input) throws Exception {
        int number1;
        int number2;
        int resultArabic;
        String result;
        String operation;
        boolean romanNumber;

        String[] expression = input.split(" ");

        if (expression.length != 3) {
            throw new Exception("Не верно введено выражение");
        }

        operation = getOperation(expression);

        String[] romanNumbers = new String[] {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
                "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
                "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
                "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
                "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
                "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
                "XCVIII", "XCIX", "C"};

        if (isRomanNumber(romanNumbers, expression[0]) && isRomanNumber(romanNumbers, expression[2])) {
            number1 = convertRomanToArabic(romanNumbers, expression[0]);
            number2 = convertRomanToArabic(romanNumbers, expression[2]);
            romanNumber = true;
        }
        else if (!isRomanNumber(romanNumbers, expression[0]) && !isRomanNumber(romanNumbers, expression[2])) {
            number1 = Integer.parseInt(expression[0]);
            number2 = Integer.parseInt(expression[2]);
            romanNumber = false;
        }
        else {
            throw new Exception("Оба числа должны быть или арабскими, или римскими");
        }

        if (number1 > 10 || number2 > 10) {
            throw new Exception("Число не должно быть больше 10");
        }

        switch (operation) {
            case "+":
                resultArabic = number1 + number2;
                break;
            case "-":
                resultArabic = number1 - number2;
                break;
            case "*":
                resultArabic = number1 * number2;
                break;
            default:
                resultArabic = number1 / number2;
                break;
        }

        if (romanNumber) {
            if (resultArabic < 1) {
                throw new Exception("Римское число может быть только больше нуля");
            }
            result = convertArabicToRoman(romanNumbers, resultArabic);
        }
        else {
            result = String.valueOf(resultArabic);
        }
        System.out.println("Ответ равен:");
        return result;
    }

    static String getOperation(String[] expression) throws Exception {
        switch (expression[1]) {
            case "+":
                return "+";
            case "-":
                return "-";
            case "*":
                return "*";
            case "/":
                return "/";
            default:
                throw new Exception("Введен неправильный оператор");
        }
    }

    static Boolean isRomanNumber(String[] romanNumbers, String value) {
        for (String romanNumber : romanNumbers) {
            if (value.equals(romanNumber)) return true;
        }
        return false;
    }

    static int convertRomanToArabic(String[] romanNumbers, String romanNumber) {
        for (int i = 0; i < romanNumbers.length; i++){
            if (romanNumber.equals(romanNumbers[i])){
                return i;
            }
        }
        return -1;
    }

    static String convertArabicToRoman(String[] romanNumbers, int arabicNumber) {
        return romanNumbers[arabicNumber];
    }
}

