import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] A;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int[] res = new int[N + 1];
		int p = 0;
		for (int i = 0; i < N; i++) {
			if (res[p] < A[i]) {
				res[++p] = A[i];
			} else {
				int lo = 0, hi = p;
				while (lo + 1 < hi) {
					int mid = (lo + hi) / 2;

					if (!(A[i] <= res[mid])) lo = mid;
					else hi = mid;
				}
				res[hi] = A[i];
			}
		}
		// System.out.println(Arrays.toString(res));
		System.out.println(p);
	}

}