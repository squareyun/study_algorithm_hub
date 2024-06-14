import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

	static int N, M;
	static int[][] S;
	static int[] arr, brr;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N + 1][N + 1];
		M = N / 2;

		arr = IntStream.rangeClosed(1, N).toArray();
		brr = new int[M];

		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);
		System.out.println(answer);
	}

	static void dfs(int cnt, int start) {
		if (cnt == M) {
			answer = Math.min(answer, calculate());
			return;
		}

		for (int i = start; i < N; i++) {
			brr[cnt] = arr[i];
			dfs(cnt + 1, i + 1);
			if (cnt == 0)
				return; // 1로 시작하는 거만 확인. 나머지는 중복
		}
	}

	static int calculate() {
		int[] crr = new int[M];
		int idx = 0, idx2 = 0;
		for (int i = 1; i <= N; i++) {
			if (idx < M && i == brr[idx]) {
				idx++;
				continue;
			}
			crr[idx2++] = i;
		}

		int startTeam = 0;
		int linkTeam = 0;
		for (int i = 0; i < M - 1; i++) {
			for (int j = i + 1; j < M; j++) {
				startTeam += S[brr[i]][brr[j]] + S[brr[j]][brr[i]];
				linkTeam += S[crr[i]][crr[j]] + S[crr[j]][crr[i]];
			}
		}

		return Math.abs(startTeam - linkTeam);
	}
}