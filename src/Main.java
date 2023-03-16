import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String equation = scanner.nextLine();
                if (equation.equals("quit")) {
                    System.out.println("Program is finished");
                    break;}
                var total = Calculator.Evaluate(equation);
                System.out.println(total);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Ошибка. Некорректное выражение");
                break;
            }

        }scanner.close();
    }
}