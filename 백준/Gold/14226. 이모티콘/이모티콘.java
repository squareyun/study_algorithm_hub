import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());

		Queue<Emoticon> q = new ArrayDeque<>();
		boolean[][] v = new boolean[1001][1001];
		q.offer(new Emoticon(1, 0, 0));
		v[1][0] = true; // i: 화면에 출력된 이모티콘 개수, j: 클립보드에 복사된 이모티콘 개수

		while (!q.isEmpty()) {
			Emoticon cur = q.poll();
			int screen = cur.screen;
			int clipboard = cur.clipboard;
			int cnt = cur.cnt;

			if (screen == S) {
				System.out.println(cnt);
				break;
			}

			// 1. 클립보드 저장
			if (screen != clipboard)
				q.offer(new Emoticon(screen, screen, cnt + 1));

			// 2. 클립보드 붙여넣기
			if (screen + clipboard <= S && !v[screen + clipboard][clipboard]) {
				q.offer(new Emoticon(screen + clipboard, clipboard, cnt + 1));
				v[screen + clipboard][clipboard] = true;
			}

			// 3. 하나 삭제
			if (screen >= 1 && !v[screen - 1][clipboard]) {
				q.offer(new Emoticon(screen - 1, clipboard, cnt + 1));
				v[screen - 1][clipboard] = true;
			}
		}

	}

	static class Emoticon {
		int screen, clipboard, cnt;

		public Emoticon(int screen, int clipboard, int cnt) {
			this.screen = screen;
			this.clipboard = clipboard;
			this.cnt = cnt;
		}
	}
}