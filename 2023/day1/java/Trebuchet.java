import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

        StringBuilder leftWord = new StringBuilder();
        StringBuilder rightWord = new StringBuilder();
        for (int left = 0, right = line.length() - 1; left <= right;) {
            if (conversion.containsKey(leftWord.toString())) {
                result.put(LEFT_DIGIT, conversion.get(leftWord.toString()));
                leftWord.setLength(0);
            } else if (result.get(LEFT_DIGIT) == ' ') {
                if (Character.isDigit(line.charAt(left))) {
                    result.put(LEFT_DIGIT, line.charAt(left));
                }
                leftWord.append(line.charAt(left));
                left++;
            }
            if (result.get(RIGHT_DIGIT) == ' ') {
                if (conversion.containsKey(rightWord.toString())) {
                    result.put(RIGHT_DIGIT, conversion.get(rightWord.toString()));
                    rightWord.setLength(0);
                } else if (Character.isDigit(line.charAt(right))) {
                    result.put(RIGHT_DIGIT, line.charAt(right));
                }
                rightWord.insert(0, line.charAt(right));
                right--;
            }

            if (result.get(RIGHT_DIGIT) != ' ' && result.get(LEFT_DIGIT) != ' ')
                break;
        }

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
