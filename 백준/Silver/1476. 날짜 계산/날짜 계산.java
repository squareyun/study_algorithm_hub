import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int E, S, M;
		E = sc.nextInt();
		S = sc.nextInt();
		M = sc.nextInt();

		int i = 1;
		int j = 1;
		int k = 1;
		int answer = 1;
		while (true) {
			if (i == E && j == S && k == M) {
				System.out.println(answer);
				return;
			}

			i = i % 15 + 1;
			j = j % 28 + 1;
			k = k % 19 + 1;
			answer++;
		}
	}
}