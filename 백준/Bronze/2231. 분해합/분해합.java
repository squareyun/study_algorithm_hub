import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		for (int i = 1; i < 1_000_000; i++) {
			if (i > N) break;

			char[] arr = String.valueOf(i).toCharArray();
			int sum = i;
			for (int c : arr) {
				sum += c - '0';
			}
			if (sum == N) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}

}