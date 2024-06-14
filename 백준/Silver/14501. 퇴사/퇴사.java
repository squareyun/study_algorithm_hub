import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] T, P;
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		solve(0, 0);
		System.out.println(answer);
	}

	static void solve(int day, int sum) {
		if (day == N) {
			answer = Math.max(answer, sum);
			return;
		}
		if (day > N) return;

		solve(day + T[day], sum + P[day]); // 상담O
		solve(day + 1, sum); // 상담X
	}
}