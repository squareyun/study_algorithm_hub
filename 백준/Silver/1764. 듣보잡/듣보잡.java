import java.util.*;
import java.io.*;

public class Main {

	static int N, M;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		HashSet<String> listen = new HashSet<>();
		for (int i = 0; i < N; i++) {
			listen.add(br.readLine());
		}
		List<String> ans = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String watch = br.readLine();
			if (listen.contains(watch)) {
				ans.add(watch);
			}
		}
		Collections.sort(ans);
		StringBuilder sb = new StringBuilder();
		sb.append(ans.size()).append("\n");
		for (String s : ans) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}

}