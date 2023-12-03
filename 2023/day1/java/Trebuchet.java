import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Trebuchet {
    public final static String LEFT_DIGIT = "leftDigit";
    public final static String RIGHT_DIGIT = "rightDigit";

    public static void main(String[] args) {
        String filePath = "puzzle-input.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            int total = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);

                Map<String, Character> digits = findDigits(line);
                total += computeCardinalValue(digits);
            }

            System.out.println("Total: " + total);
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Character> findDigits(String line) {
        Map<String, Character> result = new HashMap<>();
        result.put(LEFT_DIGIT, ' ');
        result.put(RIGHT_DIGIT, ' ');

        if (line.equals(" ") || line.isEmpty())
            return result;

        Map<String, Character> conversion = new HashMap<>();
        conversion.put("one", '1');
        conversion.put("two", '2');
        conversion.put("three", '3');
        conversion.put("four", '4');
        conversion.put("five", '5');
        conversion.put("six", '6');
        conversion.put("seven", '7');
        conversion.put("eight", '8');
        conversion.put("nine", '9');

        for (int windowStart = 0, windowEnd = 0; windowEnd < line.length(); windowEnd++) {
            if (conversion.containsKey(line.substring(windowStart, windowEnd + 1))) {
                line = line.replace(line.substring(windowStart, windowEnd + 1), conversion.get(line.substring(windowStart, windowEnd + 1)) + line.substring(windowStart, windowEnd + 1).substring(1));
                windowStart = windowEnd;
            }

            if (Character.isDigit(line.charAt(windowEnd))) {
                if (line.substring(windowStart, windowEnd).length() < 3) {
                    windowStart = windowEnd + 1;
                } else {
                    windowStart++;
                    windowEnd = windowStart;
                }
            } else if ((windowEnd - windowStart) > 5) {
                windowStart++;
                windowEnd = windowStart;
            }
        }

        String resulting = line.replaceAll("[^0-9]", "");
        result.put(LEFT_DIGIT, resulting.charAt(0));
        result.put(RIGHT_DIGIT, resulting.charAt(resulting.length() - 1));

        return result;
    }

    public static int computeCardinalValue(Map<String, Character> digits) {
        int result = 0;

        if (digits.get(LEFT_DIGIT) == ' ' && digits.get(RIGHT_DIGIT) == ' ')
            return result;

        if (digits.get(LEFT_DIGIT) == ' ') {
            int number = Integer.parseInt(String.valueOf(digits.get(RIGHT_DIGIT)) + digits.get(RIGHT_DIGIT));
            result += number;
        } else if (digits.get(RIGHT_DIGIT) == ' ') {
            int number = Integer.parseInt(String.valueOf(digits.get(LEFT_DIGIT)) + digits.get(LEFT_DIGIT));
            result += number;
        } else
            result += Integer.parseInt(String.valueOf(digits.get(LEFT_DIGIT)) + digits.get(RIGHT_DIGIT));

        return result;
    }
}
