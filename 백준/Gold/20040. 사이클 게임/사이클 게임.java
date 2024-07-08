import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[] p;
	static int[] size;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p = new int[N];
		size = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = i;
			size[i] = 1;
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (find(x) == find(y)) {
				System.out.println(i);
				return;
			}

			union(x, y);
		}

		System.out.println(0);

	}

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB) return;

		if (size[rootA] <= size[rootB]) {
			p[rootA] = rootB;
			size[rootB] += size[rootA];
		} else {
			p[rootB] = rootA;
			size[rootA] += size[rootB];
		}
	}

	static int find(int a) {
		if (p[a] == a)
			return a;

		return p[a] = find(p[a]);
	}
}