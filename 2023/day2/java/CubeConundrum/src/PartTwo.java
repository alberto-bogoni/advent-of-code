import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PartTwo {

    private static final String RED_KEY = "red";
    private static final String BLUE_KEY = "blue";
    private static final String GREEN_KEY = "green";

    public static void main(String[] args) {
        String filePath = "src/puzzle-input.txt";
        List<Integer> setsPowers = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);

                String[] parts = line.split(": ");
                String gameInfo = parts[0];
                String setsInfo = parts[1];

                String gameId = gameInfo.split(" ")[1];
                String[] sets = setsInfo.split("; ");

                Map<String, Integer> bag = new HashMap<>();
                for (String set : sets) {

                    String[] colorsInfo = set.split(", ");
                    for (String colorInfo : colorsInfo) {
                        String[] info = colorInfo.split(" ");
                        int cardinality = Integer.parseInt(info[0]);
                        String color = info[1];

                        if (bag.getOrDefault(color, 0) < cardinality)
                            bag.put(color, cardinality);
                    }
                }

                setsPowers.add(bag.getOrDefault(RED_KEY, 1) * bag.getOrDefault(GREEN_KEY, 1) * bag.getOrDefault(BLUE_KEY, 1));
                bag.clear();
            }

            int total = setsPowers.stream().reduce(0, Integer::sum);
            System.out.println("Total: " + total);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
