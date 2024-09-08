import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());

			HashMap<String, List<String>> hm = new HashMap<>();
			for (int i = 0; i < n; i++) {
				String[] s = br.readLine().split(" ");
				if (hm.containsKey(s[1])) {
					hm.get(s[1]).add(s[0]);
				} else {
					List<String> list = new ArrayList<>();
					list.add(s[0]);
					hm.put(s[1], list);
				}
			}

			List<Integer> comb = new ArrayList<>();
			for (String key : hm.keySet()) {
				comb.add(hm.get(key).size());
			}

			int ans = 1;
			for (int i : comb) {
				ans *= (i + 1);
			}
			ans--;
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}