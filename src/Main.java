import java.io.*;
import custom.util.List;
import custom.util.ArrayList;
import custom.util.Arrays;

public class Main {
    public static int[] readCSV(String filePath) throws IOException {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    list.add(Integer.parseInt(line));
                }
            }
        }

        int size = list.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        String[] files = {
                "aleatorio_100.csv", "aleatorio_1000.csv", "aleatorio_10000.csv",
                "crescente_100.csv", "crescente_1000.csv", "crescente_10000.csv",
                "decrescente_100.csv", "decrescente_1000.csv", "decrescente_10000.csv"
        };

        for (String file : files) {
            System.out.println("Arquivo: " + file);
            int[] original = readCSV("data/" + file);

            int[] arr1 = Arrays.copyOf(original, original.length);
            int[] arr2 = Arrays.copyOf(original, original.length);
            int[] arr3 = Arrays.copyOf(original, original.length);

            long start, end;

            start = System.nanoTime();
            BubbleSort.sort(arr1);
            end = System.nanoTime();
            System.out.printf("Bubble Sort: %.4f ms%n", (end - start) / 1e6);

            start = System.nanoTime();
            InsertionSort.sort(arr2);
            end = System.nanoTime();
            System.out.printf("Insertion Sort: %.4f ms%n", (end - start) / 1e6);

            start = System.nanoTime();
            QuickSort.sort(arr3);
            end = System.nanoTime();
            System.out.printf("Quick Sort: %.4f ms%n", (end - start) / 1e6);

            System.out.println("----------------------------");
        }
    }
}