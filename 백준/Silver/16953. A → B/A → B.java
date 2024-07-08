import java.util.*;
import java.io.*;

public class Main {

	static int A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		Queue<int[]> q = new ArrayDeque<>();
		boolean[] v = new boolean[B + 1];
		v[A] = true;
		q.offer(new int[] {A, 0});
		int answer = -1;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int cnt = cur[1];
			
			if (x == B) {
				answer = cnt + 1;
				break;
			}

			int nx = x * 2;
			if (nx <= B && !v[nx]) {
				v[nx] = true;
				q.offer(new int[] {nx, cnt + 1});
			}

			long nx2 = x * 10L + 1;
			if (nx2 <= B) {
				nx = (int) nx2;
			} else {
				continue;
			}
			if (!v[nx]) {
				v[nx] = true;
				q.offer(new int[] {nx, cnt + 1});
			}
		}

		System.out.println(answer);
	}
}