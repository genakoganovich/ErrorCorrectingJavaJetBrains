package correcter;

import java.util.Random;

public class Main {
    private static final int SIZE = 63;
    private static final int NUMBERS = 10;
    private static final int LETTERS = 26;
    private static final char[] ALPHABET = new char[SIZE];
    private static final int STEP = 3;

    static {
        for (int i = 0; i < NUMBERS; i++) {
            ALPHABET[i] = (char)('0' + i);
        }
        for (int i = 0; i < LETTERS; i++) {
            ALPHABET[NUMBERS + i] = (char) ('a' + i);
        }
        for (int i = 0; i < LETTERS; i++) {
            ALPHABET[NUMBERS + LETTERS + i] = (char) ('A' + i);
        }
        ALPHABET[SIZE - 1] = ' ';
    }

    public static void main(String[] args) {
        Random random = new Random();
        char[] input = new java.util.Scanner(System.in).nextLine().toCharArray();
        for (int i = 0; i < input.length; i += STEP) {
            input[getIndex(random, input, i)] = ALPHABET[random.nextInt(SIZE)];
        }
        System.out.println(String.valueOf(input));
    }

    public static int getIndex(Random random, char[] input, int i) {
        return Math.min(random.nextInt(STEP) + i, input.length - 1);
    }
}
