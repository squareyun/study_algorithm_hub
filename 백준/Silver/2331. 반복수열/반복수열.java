import java.util.*;
import java.io.*;

public class Main {

    static int[] v = new int[1_000_000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        System.out.println(dfs(a, p, 1));
    }

    static int dfs(int a, int p, int cnt) {
        if (v[a] != 0)
            return v[a] - 1;

        v[a] = cnt;
        int next = getNext(a, p);
        return dfs(next, p, cnt + 1);
    }

    private static int getNext(int a, int p) {
        int next = 0;

        while (a > 0) {
            next += (int) Math.pow(a % 10, p);
            a /= 10;
        }

        return next;
    }

}