import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] korea = {'K', 'O', 'R', 'E', 'A'};
        int idx = 0, ans = 0;
        for (char c : s.toCharArray()) {
            if (c == korea[idx]) {
                idx++;
                ans++;
                if (idx == 5) {
                    idx = 0;
                }
            }
        }
        System.out.println(ans);
    }

}