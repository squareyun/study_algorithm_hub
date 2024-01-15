import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			String p = sc.next();
			int n = sc.nextInt();
			String temp_s = sc.next();
			String s = temp_s.substring(1, temp_s.length() - 1);
			StringTokenizer st = new StringTokenizer(s, ",");
			ArrayDeque<Integer> q = new ArrayDeque<>();
			for (int i = 0; i < n; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}

			if (q.isEmpty() && (!p.contains("D"))) {
				sb.append("[]").append("\n");
				continue;
			}

			boolean isError = false;
			boolean isRevere = false;
			for (int i = 0; i < p.length(); i++) {
				if (q.isEmpty()) {
					isError = true;
					break;
				}

				char cmd = p.charAt(i);
				if (cmd == 'R') {
					isRevere = !isRevere;
				} else if (cmd == 'D') {
					if (isRevere) {
						q.pollLast();
					} else {
						q.pollFirst();
					}
				}
			}
			if (isError) {
				sb.append("error").append("\n");
			} else {
				sb.append("[");
				if (!q.isEmpty()) {
					if (isRevere) {
						sb.append(q.pollLast());
						while (!q.isEmpty()) {
							sb.append(",").append(q.pollLast());
						}
					} else {
						sb.append(q.pollFirst());
						while (!q.isEmpty()) {
							sb.append(",").append(q.pollFirst());
						}
					}
				}
				sb.append("]").append("\n");
			}
		}
		System.out.println(sb);
	}
}