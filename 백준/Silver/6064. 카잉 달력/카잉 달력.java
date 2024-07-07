import java.util.*;
import java.io.*;

public class Main {

	static int T;
	static int M, N, x, y;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			sb.append(solve()).append("\n");
		}

		System.out.println(sb);
	}

	static int solve() {

		/**
		 * x 값 고정하고, y 값을 M만큼 늘려가며 확인
		 */

		int cnt = x;
		int ny = x % N;
		if (ny == 0) ny = N;
		int nyOrigin = ny;

		if (ny == y)
			return cnt;

		while (true) {
			ny = (ny + M) % N;
			if (ny == 0) ny = N;

			cnt += M;

			if (ny == y) break;
			if (ny == nyOrigin) return -1;
		}

		return cnt;
	}
}