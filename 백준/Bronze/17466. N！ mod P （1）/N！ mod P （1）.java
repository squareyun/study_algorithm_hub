import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		System.out.println(solve(N, P));
	}

	static long solve(int N, int P) {
		if (N < P)
			return factorialMod(N, P);
		else
			return factorialMod(P - 1, P);
	}

	static long factorialMod(int K, int P) {
		long answer = 1;
		for (int i = 2; i <= K; i++) {
			answer = (answer * i) % P;
		}
		return answer;
	}
}