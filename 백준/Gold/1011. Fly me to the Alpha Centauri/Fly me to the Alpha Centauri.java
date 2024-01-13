import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			int d = y - x;
			int n = (int) Math.sqrt(d);

			if (d == n * n) { // 제곱수
				sb.append(2 * n - 1).append("\n");
			} else if (d <= n * n + n) {
				sb.append(2 * n).append("\n");
			} else {
				sb.append(2 * n + 1).append("\n");
			}
		}

		System.out.println(sb);
	}
}