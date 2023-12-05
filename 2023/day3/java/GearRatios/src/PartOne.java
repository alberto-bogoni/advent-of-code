import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PartOne {

    public static void main(String[] args) {
        String filePath = "src/puzzle-input.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            final int numberOfLines = 140;
            int lineLength = 0;
            List<Boolean> schemaMask = null;
            List<Character> schematic = null;
            List<Integer> parts = new LinkedList<>();
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                if (schemaMask == null) {
                    schemaMask = new ArrayList<>(numberOfLines * line.length());
                    schematic = new ArrayList<>(numberOfLines * line.length());
                    lineLength = line.length();
                }

                for (int i = 0; i < line.length(); i++) {
                    char currentChar = line.charAt(i);
                    schemaMask.add((isSymbol(currentChar)));
                    schematic.add(currentChar);
                }

            }

            for (int i = 0; i < schemaMask.size(); i++) {
                if (schemaMask.get(i)) {
                    List<Character> chars = List.of(
                            // Upper char
                            schematic.get(i - lineLength),
                            // Lower char
                            schematic.get(i + lineLength),
                            // Just left
                            schematic.get(i - 1),
                            // Just right
                            schematic.get(i + 1),
                            // Upper right
                            schematic.get(i - lineLength + 1),
                            // Upper left
                            schematic.get(i - lineLength - 1),
                            // Lower right
                            schematic.get(i + lineLength + 1),
                            // Lower left
                            schematic.get(i + lineLength - 1)
                    );

                    chars.forEach(c -> {
                        if (Character.isDigit(c))
                            parts.add(c - '0');
                    });
                }
            }

            System.out.println("Total: " + parts.stream().reduce(0, Integer::sum));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isSymbol(Character c) {
        return !(Character.isDigit(c) || c == '.');
    }
}
