import java.util.*;
import java.io.*;

public class Main {

    static int[][] map, result;
    static int N, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            result = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    result[i][j] = map[i][j];
                }
            }

            if (d < 0) d += 360;
            d %= 360;
            d /= 45;

            while (d --> 0)
                rotate();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(result[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    static void rotate() {
        int M = N / 2;
        for (int i = 0; i < N; i++) {
            result[i][M] = map[i][i];
            result[i][i] = map[M][i];
            result[M][i] = map[N - i - 1][i];
            result[N - i - 1][i] = map[N - i - 1][M];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = result[i][j];
            }
        }
    }

}