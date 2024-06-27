import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		int start = 0, end = 0;
		int answer = 4;
		while (end < N) {
			if (arr[end] - arr[start] < 5) {
				answer = Math.min(answer, 5 - (end - start + 1));
				end++;
			} else {
				start++;
			}
		}
		System.out.println(answer);
	}
}