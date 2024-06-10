import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> q = new ArrayDeque<>();

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int X = 0;
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			if (op.startsWith("push")) {
				X = Integer.parseInt(st.nextToken());
			}

			switch(op) {
				case "push_front":
					q.addFirst(X);
					break;
				case "push_back":
					q.addLast(X);
					break;
				case "pop_front":
					if (q.isEmpty())
						sb.append(-1).append("\n");
					else
						sb.append(q.pollFirst()).append("\n");
					break;
				case "pop_back":
					if (q.isEmpty())
						sb.append(-1).append("\n");
					else
						sb.append(q.pollLast()).append("\n");
					break;
				case "size":
					sb.append(q.size()).append("\n");
					break;
				case "empty":
					sb.append(q.isEmpty() ? 1 : 0).append("\n");
					break;
				case "front":
					if (q.isEmpty())
						sb.append(-1).append("\n");
					else
						sb.append(q.peekFirst()).append("\n");
					break;
				case "back":
					if (q.isEmpty())
						sb.append(-1).append("\n");
					else
						sb.append(q.peekLast()).append("\n");
					break;
			}
		}
		System.out.println(sb);
	}
}