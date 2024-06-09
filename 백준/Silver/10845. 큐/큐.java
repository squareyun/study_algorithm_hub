import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> q = new ArrayDeque<>();

		StringTokenizer st;
		int x = 0;
		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if (cmd.equals("push")) {
				x = Integer.parseInt(st.nextToken());
			}

			switch (cmd) {
				case "push":
					q.add(x); break;
				case "pop":
					if (q.isEmpty())
						sb.append(-1).append("\n");
					else
						sb.append(q.removeFirst()).append("\n");
					break;
				case "size":
					sb.append(q.size()).append("\n");
					break;
				case "empty":
					if (q.isEmpty())
						sb.append(1).append("\n");
					else
						sb.append(0).append("\n");
					break;
				case "front":
					if (q.isEmpty())
						sb.append(-1).append("\n");
					else
						sb.append(q.getFirst()).append("\n");
					break;
				case "back":
					if (q.isEmpty())
						sb.append(-1).append("\n");
					else
						sb.append(q.getLast()).append("\n");
					break;
			}
		}

		System.out.println(sb);
	}
}