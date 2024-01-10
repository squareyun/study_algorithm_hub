import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N, M;
	static ArrayList<Integer>[] edges;
	static boolean[] v;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		edges = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			edges[from].add(to);
			edges[to].add(from);
		}

		int answer = 0;
		v = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			if (!v[i]) {
				dfs(i);
				answer++;
			}
		}

		System.out.println(answer);
	}

	static void dfs(int from) {
		v[from] = true;

		for (int i = 0; i < edges[from].size(); i++) {
			int to = edges[from].get(i);
			if (!v[to]) {
				dfs(to);
			}
		}
	}
}