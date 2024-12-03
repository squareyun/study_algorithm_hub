import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < K; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a == 0) {
                q.pollLast();
            } else {
                q.addLast(a);
            }
        }
        long ans = 0;
        while (!q.isEmpty()) {
            ans += q.pollLast();
        }
        System.out.println(ans);
    }

}