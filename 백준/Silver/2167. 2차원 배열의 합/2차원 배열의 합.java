import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N + 1][M + 1];
        int[][] ps = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                ps[i][j] = ps[i][j - 1] + A[i][j];
            }
        }

        for (int j = 1; j <= M; j++) {
            for (int i = 1; i <= N; i++) {
                ps[i][j] += ps[i - 1][j];
            }
        }

        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int j1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            int j2 = Integer.parseInt(st.nextToken());

            int sum = ps[i2][j2]
                    - ps[i1 - 1][j2]
                    - ps[i2][j1 - 1]
                    + ps[i1 - 1][j1 - 1];
            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }
}
