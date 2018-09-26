package optional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;


public class RandomTextGenerator {

    public static void main(String[] args) throws IOException {
        Files.write(Paths.get("random20180926001.txt"), getContent(100).toString().getBytes());
        System.out.println("---done---");
    }

    static StringBuilder getContent(int rows) {
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            content.append(getLine());
        }
        return content;
    }

    static StringBuilder getLine() {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int len = getRandomLength();
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < len; j++)
                str.append(getRandomCharacter());
            line.append(str.append(" "));
        }

        line.append("\n");
        return line;
    }

    static char getRandomCharacter() {
        int code = (int) (Math.random() * (122 - 65) + 64);
        return (char) code;
    }

    static int getRandomLength() {
        return (int) (Math.random() * 12 + 3);
    }

}
