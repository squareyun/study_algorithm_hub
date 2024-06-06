import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] arr = new int[9];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}

		int a = 0, b = 0;
		loop:
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - (arr[i] + arr[j]) == 100) {
					a = i;
					b = j;
					break loop;
				}
			}
		}

		int[] brr = new int[7];
		int idx = 0;
		for (int i = 0; i < 9; i++) {
			if (i == a || i == b)
				continue;
			brr[idx++] = arr[i];
		}
		Arrays.sort(brr);
		for (int i = 0; i < 7; i++) {
			System.out.println(brr[i]);
		}
	}
}