import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TrebuchetTest {

    @Test
    public void testFindDigits() {
        Map<String, Character> expected = new HashMap<>();
        expected.put(Trebuchet.LEFT_DIGIT, '7');
        expected.put(Trebuchet.RIGHT_DIGIT, '1');

        String line = "sevensixmb68sixthreefive1";

        Map<String, Character> result = Trebuchet.findDigits(line);

        Assert.assertEquals(expected.get(Trebuchet.LEFT_DIGIT), result.get(Trebuchet.LEFT_DIGIT));
        Assert.assertEquals(expected.get(Trebuchet.RIGHT_DIGIT), result.get(Trebuchet.RIGHT_DIGIT));
    }

    @Test
    public void testFindDigitsWithOneNumber() {
        Map<String, Character> expected = new HashMap<>();
        expected.put(Trebuchet.LEFT_DIGIT, '4');
        expected.put(Trebuchet.RIGHT_DIGIT, '4');

        String line = "4sbvcnsjdmkddddddddd";

        Map<String, Character> result = Trebuchet.findDigits(line);

        Assert.assertEquals(2, result.size());
        Assert.assertEquals(expected.get(Trebuchet.LEFT_DIGIT), result.get(Trebuchet.LEFT_DIGIT));
        Assert.assertEquals(expected.get(Trebuchet.RIGHT_DIGIT), result.get(Trebuchet.RIGHT_DIGIT));
    }

    @Test
    public void testFindDigitsWithEmptyLine() {
        Map<String, Character> expected = new HashMap<>();
        expected.put(Trebuchet.LEFT_DIGIT, ' ');
        expected.put(Trebuchet.RIGHT_DIGIT, ' ');

        String line = "";

        Map<String, Character> result = Trebuchet.findDigits(line);

        Assert.assertEquals(2, result.size());
        Assert.assertEquals(expected.get(Trebuchet.LEFT_DIGIT), result.get(Trebuchet.LEFT_DIGIT));
        Assert.assertEquals(expected.get(Trebuchet.RIGHT_DIGIT), result.get(Trebuchet.RIGHT_DIGIT));
    }

    @Test
    public void find_digits_with_space_in_line_returns_empty_digits() {
        Map<String, Character> expected = new HashMap<>();
        expected.put(Trebuchet.LEFT_DIGIT, ' ');
        expected.put(Trebuchet.RIGHT_DIGIT, ' ');

        String line = " ";

        Map<String, Character> result = Trebuchet.findDigits(line);

        Assert.assertEquals(2, result.size());
        Assert.assertEquals(expected.get(Trebuchet.LEFT_DIGIT), result.get(Trebuchet.LEFT_DIGIT));
        Assert.assertEquals(expected.get(Trebuchet.RIGHT_DIGIT), result.get(Trebuchet.RIGHT_DIGIT));
    }

    @Test
    public void find_spelled_digits() {
        Map<String, Character> expected = new HashMap<>();
        expected.put(Trebuchet.LEFT_DIGIT, '2');
        expected.put(Trebuchet.RIGHT_DIGIT, '9');

        String line = "two1nine";

        Map<String, Character> result = Trebuchet.findDigits(line);

        Assert.assertEquals(2, result.size());
        Assert.assertEquals(expected.get(Trebuchet.LEFT_DIGIT), result.get(Trebuchet.LEFT_DIGIT));
        Assert.assertEquals(expected.get(Trebuchet.RIGHT_DIGIT), result.get(Trebuchet.RIGHT_DIGIT));
    }

    @Test
    public void find_spelled_digits_shifted() {
        Map<String, Character> expected = new HashMap<>();
        expected.put(Trebuchet.LEFT_DIGIT, '1');
        expected.put(Trebuchet.RIGHT_DIGIT, '9');

        String line = "tw11nine";

        Map<String, Character> result = Trebuchet.findDigits(line);

        Assert.assertEquals(2, result.size());
        Assert.assertEquals(expected.get(Trebuchet.LEFT_DIGIT), result.get(Trebuchet.LEFT_DIGIT));
        Assert.assertEquals(expected.get(Trebuchet.RIGHT_DIGIT), result.get(Trebuchet.RIGHT_DIGIT));
    }

    @Test
    public void find_spelled_digits_not_at_start() {
        Map<String, Character> expected = new HashMap<>();
        expected.put(Trebuchet.LEFT_DIGIT, '2');
        expected.put(Trebuchet.RIGHT_DIGIT, '2');

        String line = "ddtwo34dddnitwouuu";

        Map<String, Character> result = Trebuchet.findDigits(line);

        Assert.assertEquals(2, result.size());
        Assert.assertEquals(expected.get(Trebuchet.LEFT_DIGIT), result.get(Trebuchet.LEFT_DIGIT));
        Assert.assertEquals(expected.get(Trebuchet.RIGHT_DIGIT), result.get(Trebuchet.RIGHT_DIGIT));
    }

    @Test
    public void find_composed_spelled_digits() {
        Map<String, Character> expected = new HashMap<>();
        expected.put(Trebuchet.LEFT_DIGIT, '8');
        expected.put(Trebuchet.RIGHT_DIGIT, '3');

        String line = "eighthree";

        Map<String, Character> result = Trebuchet.findDigits(line);

        Assert.assertEquals(2, result.size());
        Assert.assertEquals(expected.get(Trebuchet.LEFT_DIGIT), result.get(Trebuchet.LEFT_DIGIT));
        Assert.assertEquals(expected.get(Trebuchet.RIGHT_DIGIT), result.get(Trebuchet.RIGHT_DIGIT));
    }

    @Test
    public void find_() {
        Map<String, Character> expected = new HashMap<>();
        expected.put(Trebuchet.LEFT_DIGIT, '4');
        expected.put(Trebuchet.RIGHT_DIGIT, '1');

        String line = "4onesevenone";

        Map<String, Character> result = Trebuchet.findDigits(line);

        Assert.assertEquals(2, result.size());
        Assert.assertEquals(expected.get(Trebuchet.LEFT_DIGIT), result.get(Trebuchet.LEFT_DIGIT));
        Assert.assertEquals(expected.get(Trebuchet.RIGHT_DIGIT), result.get(Trebuchet.RIGHT_DIGIT));
    }

   @Test
   public void computeCardinalValueWithEmptyDigits() {
       Map<String, Character> digits = new HashMap<>();
       digits.put(Trebuchet.LEFT_DIGIT, ' ');
       digits.put(Trebuchet.RIGHT_DIGIT, ' ');

       Assert.assertEquals(0, Trebuchet.computeCardinalValue(digits));
   }

    @Test
    public void computeCardinalValueWithBothDigits() {
        Map<String, Character> digits = new HashMap<>();
        digits.put(Trebuchet.LEFT_DIGIT, '5');
        digits.put(Trebuchet.RIGHT_DIGIT, '6');

        Assert.assertEquals(56, Trebuchet.computeCardinalValue(digits));
    }

    @Test
    public void computeCardinalValueWithOnlyLeftDigit() {
        Map<String, Character> digits = new HashMap<>();
        digits.put(Trebuchet.LEFT_DIGIT, '5');
        digits.put(Trebuchet.RIGHT_DIGIT, ' ');

        Assert.assertEquals(55, Trebuchet.computeCardinalValue(digits));
    }

    @Test
    public void computeCardinalValueWithOnlyRightDigit() {
        Map<String, Character> digits = new HashMap<>();
        digits.put(Trebuchet.LEFT_DIGIT, ' ');
        digits.put(Trebuchet.RIGHT_DIGIT, '5');

        Assert.assertEquals(55, Trebuchet.computeCardinalValue(digits));
    }
}
