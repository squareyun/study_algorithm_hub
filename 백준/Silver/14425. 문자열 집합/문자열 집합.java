import java.util.*;
import java.io.*;

public class Main {

	static int N, M;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		HashSet<String> hs = new HashSet<>();
		for (int i = 0; i < N; i++) {
			hs.add(br.readLine());
		}
		int ans = 0;
		for (int i = 0; i < M; i++) {
			if (hs.contains(br.readLine())) {
				ans++;
			}
		}
		System.out.println(ans);
	}

}