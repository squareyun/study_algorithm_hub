import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] D = new int[100_001];

		D[1] = 3;
		D[2] = 7;
		D[3] = 17;
		for (int i = 4; i <= N; i++) {
			D[i] = ( D[i - 1] + (2 * D[i - 2]) + (D[i - 1] - D[i - 2]) ) % 9901;
		}
		System.out.println(D[N]);
	}
}