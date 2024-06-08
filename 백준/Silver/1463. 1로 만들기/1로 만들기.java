import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int[] arr = new int[X + 1];

		arr[1] = 0;

		for (int i = 2; i <= X; i++) {
			arr[i] = arr[i - 1] + 1;
			if (i % 3 == 0)
				arr[i] = Math.min(arr[i], arr[i / 3] + 1);
			if (i % 2 == 0)
				arr[i] = Math.min(arr[i], arr[i / 2] + 1);
		}

		System.out.println(arr[X]);
	}
}