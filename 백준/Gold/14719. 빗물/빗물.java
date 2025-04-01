import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[] blocks = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			blocks[i] = Integer.parseInt(st.nextToken());
		}

		int[] lMax = new int[W];
		int[] rMax = new int[W];

		lMax[0] = blocks[0];
		for (int i = 1; i < W; i++) {
			lMax[i] = Math.max(lMax[i - 1], blocks[i]);
		}

		rMax[W - 1] = blocks[W - 1];
		for (int i = W - 2; i >= 0; i--) {
			rMax[i] = Math.max(rMax[i + 1], blocks[i]);
		}

		int ans = 0;
		for (int i = 0; i < W; i++) {
			int minH = Math.min(lMax[i], rMax[i]);
			ans += minH - blocks[i];
		}

		System.out.println(ans);
	}

}