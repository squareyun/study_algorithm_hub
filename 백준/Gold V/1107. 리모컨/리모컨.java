import java.util.Scanner;

public class Main {

	static int N, M;
	static boolean[] isBroken;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		isBroken = new boolean[10];

		for (int i = 0; i < M; i++) {
			isBroken[sc.nextInt()] = true;
		}

		System.out.println(solve());
	}

	static int solve() {
		if (M == 10)
			return Math.abs(N - 100);

		if (N == 100)
			return 0;

		int answer = Math.abs(N - 100);
		int score = 0;
		boolean isValid;

		for (int i = 0; i <= 999_999; i++) {
			String cur = Integer.toString(i);
			isValid = true;

			for (int j = 0; j < cur.length(); j++) {
				if (isBroken[cur.charAt(j) - '0']) {
					isValid = false;
					break;
				}
			}

			if (isValid) {
				score = Math.abs(N - i) + cur.length();
				answer = Math.min(answer, score);
			}
		}

		return answer;
	}
}