import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] first = new int[26];
        int[] second = new int[26];
        Arrays.fill(first, -1);

        for (int i = 0; i < 52; i++) {
            char ch = s.charAt(i);
            int idx = ch - 'A';

            if (first[idx] == -1)
                first[idx] = i;
            else
                second[idx] = i;
        }

        int result = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                int a0 = first[i];
                int a1 = second[i];
                int b0 = first[j];
                int b1 = second[j];

                if ((a0 < b0 && b0 < a1 && a1 < b1) ||
                        (b0 < a0 && a0 < b1 && b1 < a1)) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
