import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PartOne {

    private static final int RED_CUBES_LIMIT = 12;
    private static final int GREEN_CUBES_LIMIT = 13;
    private static final int BLUE_CUBES_LIMIT = 14;

    private static final String RED_KEY = "red";
    private static final String BLUE_KEY = "blue";
    private static final String GREEN_KEY = "green";

    public static void main(String[] args) {
        String filePath = "src/puzzle-input.txt";
        List<Integer> validGames = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);

                String[] parts = line.split(": ");
                String gameInfo = parts[0];
                String setsInfo = parts[1];

                String gameId = gameInfo.split(" ")[1];
                String[] sets = setsInfo.split("; ");

                boolean pass = true;
                for (String set: sets) {
                    Map<String, Integer> bag = new HashMap<>();

                    String[] colorsInfo = set.split(", ");
                    for (String colorInfo: colorsInfo) {
                        String[] info = colorInfo.split(" ");
                        int cardinality = Integer.parseInt(info[0]);
                        String color = info[1];

                        bag.put(color, cardinality);
                    }

                    if (bag.getOrDefault(RED_KEY, 0) > RED_CUBES_LIMIT || bag.getOrDefault(BLUE_KEY, 0) > BLUE_CUBES_LIMIT || bag.getOrDefault(GREEN_KEY, 0) > GREEN_CUBES_LIMIT)
                        pass = false;
                    bag.clear();
                }

                if (pass) {
                    System.out.printf("--------- Pass: %b -----------\n\n", pass);
                    validGames.add(Integer.parseInt(gameId));
                }
            }

            int total = validGames.stream().reduce(0, Integer::sum);
            System.out.println("Total: " + total);
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}
