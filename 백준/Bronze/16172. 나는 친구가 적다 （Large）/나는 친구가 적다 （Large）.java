import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String K = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c < '0' || c > '9') {
                sb.append(c);
            }
        }
        String filtered = sb.toString();

        int m = K.length();
        int[] lps = new int[m];
        buildLps(K, lps);

        // KMP 검색으로 filtered 안에 K가 있으면 1, 없으면 0
        boolean found = kmpSearch(filtered, K, lps);
        System.out.println(found ? 1 : 0);
    }

    private static void buildLps(String pattern, int[] lps) {
        int len = 0;
        lps[0] = 0;

        for (int i = 1; i < pattern.length(); ) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    private static boolean kmpSearch(String text, String pattern, int[] lps) {
        int n = text.length();
        int m = pattern.length();
        int i = 0, j = 0;

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == m) {
                    return true;
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }
}
