import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    @Test
    public void summationIsCorrectWhenSimpleExampleIsGiven() {
        assertEquals("5/6", Calculator.Evaluate("1/2 + 1/3").toString(), "Summation is done incorrectly");
    }

    @Test
    public void subtractionIsCorrectWhenSimpleExampleIsGiven() {
        assertEquals("-13/24", Calculator.Evaluate("1/8 - 2/3").toString(), "Substation is done incorrectly");
    }

    @Test
    public void multiplicationIsCorrectWhenSimpleExampleIsGiven() {
        assertEquals("2/27", Calculator.Evaluate("4/9 * 3/18").toString(), "Multiply is done incorrectly");
    }

    @Test
    public void divisionIsCorrectWhenSimpleExampleIsGiven() {
        assertEquals("15/28", Calculator.Evaluate("5/8 / 7/6").toString(), "Divide is done incorrectly");
    }

    @Test
    public void divisionAndSummationIsCorrectWhenSimpleExampleIsGiven() {
        assertEquals("5/12", Calculator.Evaluate("1/6 - 1/2 + 3/4").toString(), "Divide is done incorrectly");
    }

    @Test
    public void summationAndMultiplicationIsCorrectWhenSimpleExampleIsGiven() {
        assertEquals("3/4", Calculator.Evaluate("1/2 + 1/3 * 3/4").toString(), "Summation is done incorrectly");
    }

    @Test
    public void multiplicationAndSubtractionIsCorrectWhenSimpleExampleIsGiven() {
        assertEquals("-1/4", Calculator.Evaluate("-1/-3 * 3/4 - 1/2").toString(), "Summation is done incorrectly");
    }

    @Test()
    public void noRightSigns1IsCorrectWhenSimpleExampleIsGiven() {
        assertThrows(Exception.class, () -> {
            Calculator.Evaluate(" 1/3 * 4/5 # 1/5");
        });
    }

    @Test()
    public void noRightSigns2IsCorrectWhenSimpleExampleIsGiven() {
        assertThrows(Exception.class, () -> {
            Calculator.Evaluate(" 2/9 + 7/8 / a/b");
        });
    }

    @Test
    @DisplayName("Division by Zero")
    public void whenDivisionByZeroShouldThrowArithmeticException (){
    }
}