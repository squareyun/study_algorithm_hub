import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int sum = 0;
		for (int i = 0; i < K; i++) {
			sum += arr[i];
		}

		int answer = sum;
		for (int i = 1; i <= N - K; i++) {
			sum -= arr[i - 1];
			sum += arr[i + K - 1];
			answer = Math.max(answer, sum);
		}

		System.out.println(answer);
	}
}