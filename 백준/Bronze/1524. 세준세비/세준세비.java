import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			PriorityQueue<Integer> S = new PriorityQueue<>();
			PriorityQueue<Integer> B = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				S.add(Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				B.add(Integer.parseInt(st.nextToken()));
			}

			while (!S.isEmpty() && !B.isEmpty()) {
				if (S.peek() == B.peek()) {
					B.poll();
				} else if (S.peek() > B.peek()) {
					B.poll();
				} else {
					S.poll();
				}
			}
			if (S.isEmpty() && B.isEmpty()) {
				sb.append("C");
			} else if (S.isEmpty()) {
				sb.append("B");
			} else {
				sb.append("S");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}