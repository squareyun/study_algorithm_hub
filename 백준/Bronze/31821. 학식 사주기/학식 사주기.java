import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int M = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < M; i++) {
            ans += arr[Integer.parseInt(br.readLine())];
        }
        System.out.println(ans);
    }

}