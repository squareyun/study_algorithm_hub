import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			Queue<Integer> q = new ArrayDeque<>();
			boolean[] v = new boolean[10000];
			StringBuilder[] cmd = new StringBuilder[10000];

			q.add(A);
			v[A] = true;
			cmd[A] = new StringBuilder();

			while (!q.isEmpty() && !v[B]) {
				int now = q.poll();

				int D = (2 * now) % 10000;
				int S = now == 0 ? 9999 : now - 1;
				int L = (now % 1000) * 10 + now / 1000;
				int R = (now % 10) * 1000 + now / 10;

				if (!v[D]) addFun(q, v, cmd, now, D, 0);
				if (!v[S]) addFun(q, v, cmd, now, S, 1);
				if (!v[L]) addFun(q, v, cmd, now, L, 2);
				if (!v[R]) addFun(q, v, cmd, now, R, 3);
			}
			ans.append(cmd[B]).append("\n");
		}
		System.out.println(ans);
	}

	private static void addFun(Queue<Integer> q, boolean[] v, StringBuilder[] cmd, int cur, int next, int flag) {
		q.add(next);
		v[next] = true;
		if (cmd[next] == null)
			cmd[next] = new StringBuilder();
		switch (flag) {
			case 0:
				cmd[next].append(cmd[cur]).append("D");
				return;
			case 1:
				cmd[next].append(cmd[cur]).append("S");
				return;
			case 2:
				cmd[next].append(cmd[cur]).append("L");
				return;
			case 3:
				cmd[next].append(cmd[cur]).append("R");
		}
	}

}