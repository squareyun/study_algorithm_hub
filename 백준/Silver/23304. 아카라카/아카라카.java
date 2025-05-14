import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] s = br.readLine().toCharArray();

        if (check(s, 0, s.length - 1)) {
            System.out.println("AKARAKA");
        } else {
            System.out.println("IPSELENTI");
        }
    }

    private static boolean check(char[] s, int l, int r) {
        if (l >= r)
            return true;

        int i = l, j = r;
        while (i < j) {
            if (s[i++] != s[j--])
                return false;
        }

        int len  = r - l + 1;
        int half = len / 2;

        return check(s, l, l + half - 1) && check(s, r - half + 1, r);
    }
}
