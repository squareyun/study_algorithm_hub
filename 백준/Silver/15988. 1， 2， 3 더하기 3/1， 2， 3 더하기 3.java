import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		long[] arr = new long[1_000_001];

		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;

		for (int i = 4; i < 1_000_001; i++) {
			arr[i] = (arr[i - 1] + arr[i - 2] + arr[i - 3]) % 1_000_000_009;
		}

		while (T-- > 0) {
			sb.append(arr[sc.nextInt()]).append("\n");
		}
		System.out.println(sb);
	}
}