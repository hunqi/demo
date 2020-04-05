package ita.chapter1;

import tij.c3.StringUtils;

import java.util.*;

public class WordPuzzle {

    static int minLen = 3;
    static int maxLen = 4;

    static List<String> dictionary = Arrays.asList(
            "this", "red", "pen", "that",
            "two", "fat", "his", "hat",
            "egg", "pear", "tea", "who",
            "end", "send");

    public static void main(String[] args) {
        char[][] arr = getMatrix();

        Set<String> words = new HashSet<>();

        //loop rows
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= arr[i].length - minLen; j++) {
                findWord(i, j, arr, words, (row, col, wordLen)->{
                    String w = "";
                    for (int l = col; l < col + wordLen && l < arr.length; l++) {
                        w += arr[row][l];
                    }
                    return w;
                });
            }
        }
        print(words);
        long end = System.currentTimeMillis();
        System.out.printf("\ncost time: %d\n", end - start);

        //loop columns
        start = System.currentTimeMillis();
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j <= arr.length - minLen; j++) {
                findWord(i, j, arr, words, (row, col, wordLen)->{
                    String w = "";
                    for (int l = col; l < col + wordLen && l < arr.length; l++) {
                        w += arr[l][row];
                    }
                    return w;
                });
            }
        }

        print(words);
        end = System.currentTimeMillis();
        System.out.printf("\ncost time: %d\n", end - start);

        //loop diagonal
        System.out.println("------diagonal upper left to low right");
        //diagonal upper left to low right
        for (int i = 0; i <= arr.length - minLen; i++) {
            findWord(i, 0, arr, words, (row, col, wordLen)->{
                String w = "";
                for (int l = row; l < row + wordLen && l < arr.length; l++)
                    w += arr[l][l];
                return w;
            });
        }
        print(words);

        System.out.println("------diagonal low left to upper right");
        for (int i = arr.length - 1; i >= minLen - 1; i--) {

            findWord(i, 0, arr, words, (row, col, wordLen)->{
                String wll = "";
                for (int l = 0; l < wordLen && l <= row; l++) {
                    wll += arr[row - l][arr.length - 1 - row + l];
                }
                return wll;
            });

        }
        print(words);
    }

    static void findWord(int rowNo, int col, char[][] arr, Set<String> words, Assembler assembler) {
        for (int k = minLen; k <= maxLen; k++) {
            String wl = assembler.run(rowNo, col, k);
            if (dictionary.contains(wl)) words.add(wl);
            String wr = StringUtils.reverse(wl);
            if (dictionary.contains(wr)) words.add(wr);
        }
    }

    static void print(Collection<? extends Object> collection) {
        for (Object obj : collection)
            System.out.printf("%s ", obj);
        System.out.println("\n");
    }

    static char[][] getMatrix() {
        char[][] arr = new char[4][4];

        arr[0] = new char[]{'t', 'h', 'i', 's'};
        arr[1] = new char[]{'w', 'o', 'e', 's'};
        arr[2] = new char[]{'o', 'n', 'h', 'd'};
        arr[3] = new char[]{'d', 'g', 'g', 'w'};

        return arr;
    }

    static interface Assembler {
        String run(int row, int col, int wordLen);
    }

}
