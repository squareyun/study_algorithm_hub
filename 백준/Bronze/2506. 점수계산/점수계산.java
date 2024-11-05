import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		int acc = 0;
		for (int a : arr) {
			if (a == 1) {
				acc++;
				ans += acc;
			} else {
				acc = 0;
			}
		}
		System.out.println(ans);
	}

}