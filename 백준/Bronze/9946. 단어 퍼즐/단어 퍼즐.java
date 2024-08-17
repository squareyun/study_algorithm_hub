import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = 1;
        String s1, s2;
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        while (!Objects.equals(s1 = br.readLine(), "END")) {
            s2 = br.readLine();
            flag = true;

            int[] alpha = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                alpha[s1.charAt(i) - 'a']++;
            }

            for (int i = 0; i < s2.length(); i++) {
                alpha[s2.charAt(i) - 'a']--;
            }

            for (int i = 0; i < 26; i++) {
                if (alpha[i] != 0) {
                    flag = false;
                    break;
                }
            }

            sb.append("Case ").append(tc).append(": ");
            sb.append(flag ? "same" : "different").append("\n");
            tc++;
        }

        System.out.println(sb);
    }
}