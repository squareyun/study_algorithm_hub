import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Integer, String> int2String = new HashMap<>();
		HashMap<String, Integer> string2Int = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			int2String.put(i, s);
			string2Int.put(s, i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if (string2Int.containsKey(s)) {
				sb.append(string2Int.get(s));
			} else {
				sb.append(int2String.get(Integer.parseInt(s)));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}