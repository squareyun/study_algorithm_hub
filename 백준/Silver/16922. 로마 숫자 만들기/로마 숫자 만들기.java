import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] arr = {1, 5, 10, 50};
	static HashSet<Integer> hs = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dfs(0, 0, 0);
		System.out.println(hs.size());
	}

	static void dfs(int cur, int sum, int start) {
		if (cur == N) {
			hs.add(sum);
			return;
		}

		for (int i = start; i < 4; i++) {
			dfs(cur + 1, sum + arr[i], i);
		}
	}

}