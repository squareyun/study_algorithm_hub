import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        final int MOD = 20000303;

        int rem = 0;

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';

            rem = (rem * 10 + digit) % MOD;
        }

        System.out.println(rem);
    }
}
