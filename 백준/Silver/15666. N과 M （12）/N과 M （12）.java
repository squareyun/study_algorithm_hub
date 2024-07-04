import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[] arr;
	static int[] brr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		brr = new int[M];
		HashSet<Integer> hs = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			hs.add(Integer.parseInt(st.nextToken()));
		}
		N = hs.size();
		arr = hs.stream().mapToInt(Integer::intValue).toArray();
		Arrays.sort(arr);
		dfs(0, 0);
		System.out.println(sb);
	}

	static void dfs(int cnt, int start) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(brr[i]).append(' ');
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < N; i++) {
			brr[cnt] = arr[i];
			dfs(cnt + 1, i);
		}
	}
}