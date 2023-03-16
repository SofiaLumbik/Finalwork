public enum Action {
    Summation(1),
    Subtraction(1),
    Multiplication(2),
    Division(2),
    OpenBracket(3),
    CloseBracket(3);
    private final Integer Priority;

    Action(int priority) {
        Priority = priority;
    }

    public Integer GetPriority() { return Priority; }
}