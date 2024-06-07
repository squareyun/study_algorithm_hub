import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		int[] arr = new int[11];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;

		int sum = 3;
		for (int i = 4; i <= 10; i++) {
			sum += arr[i - 1];
			arr[i] = sum;
			sum -= arr[i - 3];
		}

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int n = sc.nextInt();
			sb.append(arr[n]).append('\n');
		}
		System.out.println(sb);
	}
}