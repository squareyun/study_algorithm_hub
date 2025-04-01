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

		int ans = 0;

		for (int i = 1; i < W - 1; i++) {
			int lMax = 0;
			int rMax = 0;

			for (int j = 0; j < i; j++) {
				lMax = Math.max(lMax, blocks[j]);
			}

			for (int j = i + 1; j < W; j++) {
				rMax = Math.max(rMax, blocks[j]);
			}

			int minH = Math.min(lMax, rMax);
			if (minH > blocks[i]) {
				ans += minH - blocks[i];
			}
		}

		System.out.println(ans);
	}

}