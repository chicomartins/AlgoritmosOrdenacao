package custom.util;

public class Arrays {
    public static int[] copyOf(int[] original, int newLength) {
        int[] copy = new int[newLength];
        int lengthToCopy = Math.min(original.length, newLength);
        for (int i = 0; i < lengthToCopy; i++) {
            copy[i] = original[i];
        }
        return copy;
    }
}
