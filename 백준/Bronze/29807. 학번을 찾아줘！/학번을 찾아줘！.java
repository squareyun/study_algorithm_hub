import java.util.*;
import java.io.*;

public class Main {

	static int T;
	static int[] arr;
	static int answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[5];
		for (int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// System.out.println(Arrays.toString(arr));

		// 0국어, 1수학, 2영어, 3탐구, 4제2외국어

		if (arr[0] > arr[2]) {
			answer += Math.abs(arr[0] - arr[2]) * 508;
		} else {
			answer += Math.abs(arr[0] - arr[2]) * 108;
		}

		if (arr[1] > arr[3]) {
			answer += Math.abs(arr[1] - arr[3]) * 212;
		} else {
			answer += Math.abs(arr[1] - arr[3]) * 305;
		}

		answer += arr[4] * 707;

		answer *= 4763;
		System.out.println(answer);

	}
}