import java.util.*;
import java.io.*;

public class Main {

    static String s;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        dfs(0, "");
        System.out.println(ans);
    }

    static void dfs(int cnt, String cur) {
        if (cnt == s.length()) {
            for (int i = 0; i < cur.length() - 1; i++) {
                if (cur.charAt(i) == cur.charAt(i + 1)) {
                    return;
                }
            }
            ans++;
            return;
        }

        if (s.charAt(cnt) == 'c') {
            for (char c = 'a'; c <= 'z'; c++) {
                dfs(cnt + 1, cur + c);
            }
        } else if (s.charAt(cnt) == 'd') {
            for (int i = 0; i <= 9; i++) {
                dfs(cnt + 1, cur + i);
            }
        }
    }
}