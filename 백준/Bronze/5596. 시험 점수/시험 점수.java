import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[4];
		int[] brr = new int[4];
		int sumA = 0;
		for (int i = 0; i < 4; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sumA += arr[i];
		}
		st = new StringTokenizer(br.readLine());
		int sumB = 0;
		for (int i = 0; i < 4; i++) {
			brr[i] = Integer.parseInt(st.nextToken());
			sumB += brr[i];
		}
		System.out.println(Math.max(sumA, sumB));
	}
}