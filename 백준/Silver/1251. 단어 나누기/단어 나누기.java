import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int len = S.length();

        String ans = null;
        for (int i = 1; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String part1 = new StringBuilder(S.substring(0, i)).reverse().toString();
                String part2 = new StringBuilder(S.substring(i, j)).reverse().toString();
                String part3 = new StringBuilder(S.substring(j)).reverse().toString();
                String candidate = part1 + part2 + part3;

                if (ans == null || candidate.compareTo(ans) < 0) {
                    ans = candidate;
                }
            }
        }

        System.out.println(ans);
    }

}