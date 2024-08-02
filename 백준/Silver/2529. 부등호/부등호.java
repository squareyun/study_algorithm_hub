import java.util.*;
import java.io.*;

public class Main {

	static int k;
	static String[] s;
	static int[] brr;
	static boolean[] v;
	static String maxV = String.valueOf(Long.MIN_VALUE);
	static String minV = String.valueOf(Long.MAX_VALUE);

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		s = br.readLine().split(" ");
		brr = new int[k + 1];
		v = new boolean[10];
		dfs(0);
		System.out.println(maxV);
		System.out.println(minV);
	}

	static void dfs(int cnt) {
		if (cnt == k + 1) {
			boolean isValid = true;
			StringBuilder cur = new StringBuilder();
			cur.append(brr[0]);
			for (int i = 0; i < k; i++) {
				if (s[i].equals("<")) {
					if (!(brr[i] < brr[i + 1])) {
						isValid = false;
						break;
					}
				} else if (s[i].equals(">")) {
					if (!(brr[i] > brr[i + 1])) {
						isValid = false;
						break;
					}
				}
				cur.append(brr[i + 1]);
			}
			if (!isValid) return;
			if (Long.parseLong(maxV) < Long.parseLong(cur.toString())) {
				maxV = cur.toString();
			}
			if (Long.parseLong(minV) > Long.parseLong(cur.toString())) {
				minV = cur.toString();
			}
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (v[i]) continue;
			v[i] = true;
			brr[cnt] = i;
			dfs(cnt + 1);
			v[i] = false;
		}
	}

}