import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] a = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int l = 0, r = 0;
		int sum = 0, cnt = 0;
		while (r < N) {
			sum += a[r];

			while (sum > M && l <= r) {
				sum -= a[l++];
			}

			if (sum == M)
				cnt++;

			r++;
		}
		System.out.println(cnt);
	}

}