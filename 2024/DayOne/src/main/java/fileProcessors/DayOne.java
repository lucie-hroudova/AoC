package fileProcessors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class DayOne {
    public static void createDatasetFromFile(File file, Map<Integer, Integer> mapA, Map<Integer, Integer> mapB) {
        // TODO next time use Stream for files of this size
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");

                int digitA = Integer.parseInt(parts[0]);
                int digitB = Integer.parseInt(parts[1]);

                mapA.put(digitA, mapA.getOrDefault(digitA, 0) + 1);

                mapB.put(digitB, mapB.getOrDefault(digitB, 0) + 1);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            // TODO print exception
        }
    }
}
