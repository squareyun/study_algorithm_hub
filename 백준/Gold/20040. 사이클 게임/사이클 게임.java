import java.util.*;
import java.io.*;

public class Main {

	static int n, m;
	static int[] parent;
	static int[] size;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		int a, b;
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if (find(a) == find(b)) {
				System.out.println(i);
				return;
			}
			union(a, b);
		}
		System.out.println(0);
	}

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB) return;

		if (size[rootA] > size[rootB]) {
			size[rootA] += size[rootB];
			parent[rootA] = rootB;
		} else {
			size[rootB] += size[rootA];
			parent[rootB] = rootA;
		}
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;

		return parent[x] = find(parent[x]);
	}
}