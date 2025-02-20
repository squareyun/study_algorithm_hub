import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] arr, brr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        brr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0, 0);
    }

    static void dfs(int start, int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                System.out.printf("%d ", brr[i]);
            }
            System.out.println();
            return;
        }

        for (int i = start; i < N; i++) {
            brr[cnt] = arr[i];
            dfs(i + 1, cnt + 1);
        }
    }

}