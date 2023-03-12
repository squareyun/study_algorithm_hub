/**
 * Reference: https://jih3508.tistory.com/59
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static char[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        } //입력끝

        // 시작이 Black인 경우와 White인 경우 나눠서 생각
        int ans = Math.min(solution('B'), solution('W'));
        System.out.println(ans);
    }

    private static int solution(char color) {
        int cnt = Integer.MAX_VALUE;
        int[][] pSum = new int[N + 1][M + 1]; // 계산 편의를 위해서 + 1

        // 누적합 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if ((i + j) % 2 == 0) {
                    pSum[i + 1][j + 1] = (map[i][j] != color) ? 1 : 0;
                } else {
                    pSum[i + 1][j + 1] = (map[i][j] == color) ? 1 : 0;
                }
                pSum[i + 1][j + 1] += pSum[i][j + 1] + pSum[i + 1][j] - pSum[i][j];
            }
        }

        // K * K 구간합
        for (int i = 1; i <= N - K + 1; i++) {
            for (int j = 1; j <= M - K + 1; j++) {
                cnt = Math.min(cnt,
                        // 식 생각 해보기
                        pSum[i + K - 1][j + K - 1] - pSum[i - 1][j + K - 1] - pSum[i + K - 1][j - 1] + pSum[i - 1][j - 1]);
            }
        }

        return cnt;
    }
}