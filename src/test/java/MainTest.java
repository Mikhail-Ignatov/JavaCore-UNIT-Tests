import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Main;

public class MainTest {

    @Test
    public void testsTaxEarningsMinunsSpendings() {

        Main main = new Main();
        int earnings = 100, spendings = 80, expected = 3;
        int earnings1 = 80, spendings1 = 100, expected1 = 0;

        int result = main.taxEarningsMinunsSpendings(earnings, spendings);
        int result1 = main.taxEarningsMinunsSpendings(earnings1, spendings1);

        Assertions.assertEquals(expected, result);
        Assertions.assertEquals(expected1, result1);
    }

    @Test
    public void testsTaxEarnings() {

        Main main = new Main();
        int earnings = 100, expected = 6;

        int result = main.taxEarnings(earnings);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void taxSavings() {

        Main main = new Main();
        int taxEarnings = 100, taxEarningsMinunsSpending = 80, expected = 20;

        int result = main.taxSavings(taxEarnings, taxEarningsMinunsSpending);

        Assertions.assertEquals(expected, result);
    }

}

