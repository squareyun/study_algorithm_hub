import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String s = br.readLine();
            System.out.println(check(s) ? 1 : 0);
        }
    }

    static boolean check(String s) {
        if (s.length() != 7)
            return false;

        HashSet<Character> hs = new HashSet<>();
        for (char c : s.toCharArray())
            hs.add(c);
        if (hs.size() != 2)
            return false;

        char a = s.charAt(0);
        char b = s.charAt(2);
        if (a == b)
            return false;

        char[] crr = {a, a, b, b, a, b, b};
        StringBuilder sb = new StringBuilder();
        for (char c : crr) {
            sb.append(c);
        }

        return sb.toString().equals(s);
    }

}