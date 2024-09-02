import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashSet<String> hs = new HashSet<>();
		for (int i = 0; i < n; i++) {
			String[] records = br.readLine().split(" ");

			if (records[1].equals("enter")) {
				hs.add(records[0]);
			} else {
				hs.remove(records[0]);
			}
		}

		List<String> ans = new ArrayList<>(hs);
		ans.sort(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for (String s : ans) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}

}