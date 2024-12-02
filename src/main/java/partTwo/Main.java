package partTwo;

import fileProcessors.DayOne;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir") + "/src/main/resources/dayOne.txt");

        HashMap<Integer, Integer> hashMapA = new HashMap<>();
        HashMap<Integer, Integer> hashMapB = new HashMap<>();

        DayOne.createDatasetFromFile(file, hashMapA, hashMapB);

        int similarityScore = 0;

        for (Map.Entry<Integer, Integer> entry : hashMapA.entrySet()) {
            similarityScore += entry.getKey() * entry.getValue() * hashMapB.getOrDefault(entry.getKey(),0);
        }

        // 23082277
        System.out.println("Sum of all distances: " + similarityScore);
    }
}