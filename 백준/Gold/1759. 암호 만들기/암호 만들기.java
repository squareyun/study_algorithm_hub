import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int L, C;
	static char[] arr;
	static char[] brr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		arr = new char[C];
		brr = new char[L];
		for (int i = 0; i < C; i++) {
			arr[i] = sc.next().charAt(0);
		}

		// System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		// System.out.println(Arrays.toString(arr))
		dfs(0, 0);

		System.out.println(sb);
	}

	static void dfs(int start, int cnt) {
		if (cnt == L) {
			int aeiou = 0;

			for (char c : brr) {
				switch (c) {
					case 'a':
					case 'e':
					case 'i':
					case 'o':
					case 'u':
						aeiou++;
				}
			}

			if (aeiou < 1 || (L - aeiou) < 2)
				return;

			for (int i = 0; i < L; i++) {
				sb.append(brr[i]);
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < C; i++) {
			brr[cnt] = arr[i];
			dfs(i + 1, cnt + 1);
		}
	}
}