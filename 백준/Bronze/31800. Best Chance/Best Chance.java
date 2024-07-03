import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] profit, price, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		profit = new int[N];
		price = new int[N];
		ans = new int[N];

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			profit[i] = Integer.parseInt(st.nextToken());
			pq.offer(profit[i]);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			boolean flag = false;
			List<Integer> temp = new ArrayList<>();
			int cur = 0;
			while (!pq.isEmpty()) {
				cur = pq.poll();
				temp.add(cur);
				if (cur == profit[i]) {
					if (!flag) {
						flag = true;
						continue;
					} else
						break;
				}
				break;
			}
			for (int t : temp)
				pq.offer(t);
			int gibi = cur - price[i];
			ans[i] = profit[i] - gibi - price[i];
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(ans[i]).append(' ');
		}
		System.out.println(sb);
	}
}