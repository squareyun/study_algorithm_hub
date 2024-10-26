import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(br.readLine());
		}
		char[] ans = list.get(0).toCharArray();
		int len = ans.length;
		for (int i = 1; i < N; i++) {
			char[] cur = list.get(i).toCharArray();

			for (int j = 0; j < len; j++) {
				if (ans[j] != cur[j])
					ans[j] = '?';
			}
		}
		StringBuilder sb = new StringBuilder();
		for (char an : ans) {
			sb.append(an);
		}
		System.out.println(sb);
	}

}