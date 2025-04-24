import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dasom = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.println("0");
			return;
		}

		Integer[] arr = new Integer[N - 1];
		for (int i = 0; i < N - 1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr, Collections.reverseOrder());
		int ans = 0;
		while (dasom <= arr[0]) {
			arr[0]--;
			dasom++;
			ans++;
			Arrays.sort(arr, Collections.reverseOrder());
		}
		System.out.println(ans);
	}

}