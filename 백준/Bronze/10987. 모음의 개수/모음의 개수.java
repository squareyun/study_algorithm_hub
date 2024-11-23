import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        HashSet<Character> hs = new HashSet<>();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (hs.contains(c)) {
                ans++;
            }
        }
        System.out.println(ans);
    }

}