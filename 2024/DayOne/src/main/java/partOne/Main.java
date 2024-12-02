package partOne;

import fileProcessors.DayOne;

import java.io.File;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir") + "/src/main/resources/dayOne.txt");

        TreeMap<Integer, Integer> treeMapA = new TreeMap<>();
        TreeMap<Integer, Integer> treeMapB = new TreeMap<>();

        DayOne.createDatasetFromFile(file, treeMapA, treeMapB);

        int sumOfAllDistances = 0;

        Integer minKeyA = treeMapA.firstKey();
        Integer minKeyB = treeMapB.firstKey();

        while (minKeyA != null && minKeyB != null) {

            int valueA = treeMapA.get(minKeyA);
            int valueB = treeMapB.get(minKeyB);

            sumOfAllDistances += Math.abs(minKeyA - minKeyB);

            if (valueA > 1) {
                treeMapA.put(minKeyA, valueA - 1);
            } else {
                treeMapA.remove(minKeyA);
                minKeyA = treeMapA.isEmpty() ? null : treeMapA.firstKey();
            }

            if (valueB > 1) {
                treeMapB.put(minKeyB, valueB - 1);
            } else {
                treeMapB.remove(minKeyB);
                minKeyB = treeMapB.isEmpty() ? null : treeMapB.firstKey();
            }
        }

        // 2375403
        System.out.println("Sum of all distances: " + sumOfAllDistances);
    }
}