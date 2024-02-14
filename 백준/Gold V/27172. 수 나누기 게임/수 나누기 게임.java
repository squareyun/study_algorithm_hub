import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		boolean[] v = new boolean[1_000_001];
		int[] answer = new int[1_000_001];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			v[arr[i]] = true;
		}

		for (int i : arr) {
			for (int j = i * 2; j < 1_000_001; j += i) {
				if (v[j]) {
					answer[i]++;
					answer[j]--;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i : arr) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb);
	}
}