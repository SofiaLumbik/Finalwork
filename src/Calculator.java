import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;


public class Calculator {
    public static Fraction Evaluate(String equation) {
        var tokens = ParseTokens(equation);
        return EvaluateTokens(tokens);
    }

    private static ArrayList<Sign> ParseTokens(String equation) {
        var parts = equation.split(" ");
        var tokens = new ArrayList<Sign>(parts.length);
        for (var part: parts) {
            switch (part) {
                case "+" -> tokens.add(new Sign(Action.Summation));
                case "-" -> tokens.add(new Sign(Action.Subtraction));
                case "*" -> tokens.add(new Sign(Action.Multiplication));
                case "/" -> tokens.add(new Sign(Action.Division));
                case "(" -> tokens.add(new Sign(Action.OpenBracket));
                case ")" -> tokens.add(new Sign(Action.CloseBracket));
                default -> {
                    var fractionParts = part.split("/");
                    tokens.add(new Sign(new Fraction(Integer.parseInt(fractionParts[0]), Integer.parseInt(fractionParts[1]))));
                }
            }
        }
        return tokens;
    }

    private static Fraction EvaluateTokens(ArrayList<Sign> tokens) {
        var operators = new Stack<Action>();
        var reversePolishNotation = new ArrayDeque<Sign>();
        for (var token: tokens) {
            if (token.GetTokenType() == TokenType.Number) {
                reversePolishNotation.addLast(token);
                continue;
            }
            switch (token.GetAction()) {
                case Summation, Subtraction -> {
                    while (!operators.empty() && operators.peek() != Action.OpenBracket)
                        reversePolishNotation.addLast(new Sign(operators.pop()));
                    operators.push(token.GetAction());
                }
                case OpenBracket -> operators.push(token.GetAction());
                case CloseBracket -> {
                    while (operators.peek() != Action.OpenBracket)
                        reversePolishNotation.addLast(new Sign(operators.pop()));
                    operators.pop();
                }
                case Division, Multiplication -> {
                    while (!operators.empty() && operators.peek() != Action.OpenBracket && operators.peek().GetPriority().equals(token.GetAction().GetPriority()))
                        reversePolishNotation.addLast(new Sign(operators.pop()));
                    operators.push(token.GetAction());
                }
            }
        }
        while (!operators.empty()) reversePolishNotation.addLast(new Sign(operators.pop()));
        var solution = new Stack<Sign>();
        while (!reversePolishNotation.isEmpty()) {
            var cur = reversePolishNotation.pop();
            if (cur.GetTokenType() == TokenType.Number) {
                solution.push(cur);
                continue;
            }
            var first = solution.pop();
            var second = solution.pop();
            Fraction res = switch (cur.GetAction()) {
                case Summation -> first.GetNumber().Summation(second.GetNumber());
                case Subtraction -> second.GetNumber().Subtraction(first.GetNumber());
                case Multiplication -> first.GetNumber().Multiplication(second.GetNumber());
                case Division -> second.GetNumber().Division(first.GetNumber());
                default -> null;
            };
            solution.push(new Sign(res));
        }
        return solution.pop().GetNumber();
    }
}