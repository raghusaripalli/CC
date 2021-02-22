package helper;

import java.util.Arrays;
import java.util.List;

public class Helper {
    private static final String SPACE = " ";
    private static final String COMMA = ",";

    public static int[] parseStringToIntegerArray(String input) {
        String[] tokens = input.split(",");
        return Arrays.stream(tokens).mapToInt(x -> Integer.parseInt(x.trim().replace("[", "").replace("]", ""))).toArray();
    }

    public static int[] convertArrayListToBasicInt(List<Integer> array) {
        return array.stream().mapToInt(i -> i).toArray();
    }

    public static void prettyPrint(int[] arr) {
        for (int j : arr) {
            System.out.print(j + SPACE);
        }
        System.out.println();
    }
}