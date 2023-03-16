public class Sign {
    private final TokenType Type;
    private final Fraction Number;
    private final Action Action;

    public Sign(Action action) {
        Type = TokenType.Operator;
        Action = action;
        Number = null;
    }
    public Sign(Fraction number) {
        Type = TokenType.Number;
        Number = number;
        Action = null;
    }
    public TokenType GetTokenType() {
        return Type;
    }
    public Fraction GetNumber() {
        if (Number == null) {
            throw new RuntimeException("Этот токен является оператором");
        }
        return Number;
    }
    public Action GetAction() {
        if (Action == null) {
            throw new RuntimeException("Этот токен является числом");
        }
        return Action;
    }
}

enum TokenType {
    Number,
    Operator
}
