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

		int answer = 4;
		int left = 0, right = 0;
		while (right < N) {
			if (arr[right] - arr[left] < 5) {
				answer = Math.min(answer, 5 - (right - left + 1));
				right++;
			} else {
				left++;
			}
		}
		System.out.println(answer);
	}
}