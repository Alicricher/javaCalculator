import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) { // бесконечный цикл
            System.out.print("Введите выражение (или 'exit' чтобы выйти): ");
            if (input.hasNext("exit")) {
                System.out.println("Программа завершена.");
                break; // выходим из цикла
            }
            int operatorIndex = -1;
            char operatorChar = ' ';
            String expression = input.nextLine();
            for (char ch : expression.toCharArray()) {
                if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%') {
                    operatorChar = ch;
                    operatorIndex = expression.indexOf(operatorChar);
                    break;
                }
            }
            if (operatorIndex == -1) {
                System.out.println("Ошибка: не найден оператор!");
                return;
            }
            String partA = expression.substring(0, operatorIndex);
            String partB = expression.substring(operatorIndex + 1);

            try {
                double a = Double.parseDouble(partA);
                String operator = String.valueOf(operatorChar);
                double b = Double.parseDouble(partB);

                switch (operator) {
                    case "+":
                        System.out.println("Результат: " + (a + b));
                        break;
                    case "-":
                        System.out.println("Результат: " + (a - b));
                        break;
                    case "*":
                        System.out.println("Результат: " + (a * b));
                        break;
                    case "/":
                        if (b != 0) {
                            System.out.println("Результат: " + (a / b));
                        } else {
                            System.out.println("Ошибка: деление на ноль!");
                        }
                        break;
                    case "%":
                        System.out.println("Результат: " + (a % b));
                        break;
                    default:
                        System.out.println("Ошибка: Некорректный оператор!");
                        break;
            }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: неверный формат ввода.");
            }
        }

        input.close(); // закрываем Scanner
    }
}
