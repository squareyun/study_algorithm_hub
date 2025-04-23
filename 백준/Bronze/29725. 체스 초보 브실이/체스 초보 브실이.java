import java.io.*;
import java.util.*;

public class Main {
    private static final int[] val = new int[26];
    static {
        val['Q'-'A'] = 9;
        val['R'-'A'] = 5;
        val['B'-'A'] = 3;
        val['N'-'A'] = 3;
        val['P'-'A'] = 1;
        val['K'-'A'] = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int white = 0, black = 0;

        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            for (char ch : line.toCharArray()) {
                if (ch == '.') continue;
                
                int score = val[Character.toUpperCase(ch) - 'A'];

                if (Character.isUpperCase(ch))
                    white += score;
                else
                    black += score;
            }
        }
        System.out.println(white - black);
    }
}
