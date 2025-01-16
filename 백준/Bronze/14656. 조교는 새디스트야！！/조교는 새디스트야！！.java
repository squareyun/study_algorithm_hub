import java.util.*;
import java.io.*;

public class Main {

    static String s;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            if (Integer.parseInt(st.nextToken()) != i)
                ans++;
        }
        System.out.println(ans);
    }
}