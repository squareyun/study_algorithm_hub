import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

	static class Data implements Comparable<Data> {
		int idx, x, y, cnt, dir;

		public Data(int idx, int x, int y, int cnt, int dir) {
			super();
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}

		@Override
		public int compareTo(Data o) {
			if (this.idx == o.idx) {
				return o.cnt - this.cnt;
			}
			return this.idx - o.idx;
		}

	}

	static int N, M, K;
	static int[] dx = new int[] { -1, 1, 0, 0, }; // 상 하 좌 우 1 2 3 4
	static int[] dy = new int[] { 0, 0, -1, 1 };
	static ArrayList<Data> list;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				list.add(new Data(x * N + y, x, y, cnt, dir));
			}

			for (int mm = 0; mm < M; mm++) {
				
				for (int i = 0; i < list.size(); i++) {

					Data cur = list.get(i);

					cur.x = cur.x + dx[cur.dir];
					cur.y = cur.y + dy[cur.dir];
					cur.idx = (cur.x * N) + cur.y;

					if (cur.x == 0 || cur.y == 0 || cur.x == N - 1 || cur.y == N - 1) { // 약품 만나면 처리
						cur.cnt /= 2;

						if (cur.dir == 0)
							cur.dir = 1;
						else if (cur.dir == 1)
							cur.dir = 0;
						else if (cur.dir == 2)
							cur.dir = 3;
						else if (cur.dir == 3)
							cur.dir = 2;

						if (cur.cnt == 0) { // 0이 되면 군집이 사라짐
							list.remove(i);
							i--;
						}
					}
				}

				Collections.sort(list);

				// 군집들이 합쳐지는 경우
				for (int i = 0; i < list.size() - 1; i++) {
					Data a = list.get(i);
					Data b = list.get(i + 1);

					if (a.idx == b.idx) {
						a.cnt += b.cnt;
						list.remove(i + 1);
						i--;
					}
				}
			}

			int ans = 0;
			for (int i = 0; i < list.size(); i++) {
				ans += list.get(i).cnt;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
