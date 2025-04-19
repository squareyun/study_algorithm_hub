import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] A = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] score = new int[N];

        for (int j = 0; j < 3; j++) {
            int[] cnt = new int[101];
            for (int i = 0; i < N; i++) {
                cnt[A[i][j]]++;
            }

            for (int i = 0; i < N; i++) {
                if (cnt[A[i][j]] == 1) {
                    score[i] += A[i][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int s : score) {
            sb.append(s).append('\n');
        }
        System.out.print(sb);
    }
}
