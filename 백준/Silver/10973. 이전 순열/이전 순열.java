import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int i = N - 1;
		while (i > 0 && arr[i - 1] <= arr[i]) --i;
		if (i == 0) {
			System.out.println(-1);
			return;
		}

		int j = N - 1;
		while (arr[i - 1] <= arr[j]) --j;

		swap(arr, i - 1, j);

		int k = N - 1;
		while(i < k)
			swap(arr, i++, k--);

		StringBuilder sb = new StringBuilder();
		for (int a : arr) {
			sb.append(a).append(' ');
		}
		System.out.println(sb);
	}

	static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}