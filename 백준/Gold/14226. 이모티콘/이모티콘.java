import java.util.*;
import java.io.*;

public class Main {

	static int S;
	static boolean[][] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());

		v = new boolean[S + 1][S + 1];
		Queue<Emoticon> q = new LinkedList<>();
		q.offer(new Emoticon(1, 0, 0));
		v[1][0] = true;

		while (!q.isEmpty()) {
			Emoticon cur = q.poll();
			int screen = cur.screen;
			int clipboard = cur.clipboard;
			int cnt = cur.cnt;

			if (screen == S) {
				System.out.println(cnt);
				break;
			}

			if (screen != clipboard && !v[screen][screen]) {
				v[screen][screen] = true;
				q.offer(new Emoticon(screen, screen, cnt + 1));
			}

			if (screen + clipboard <= S && !v[screen + clipboard][clipboard]) {
				v[screen + clipboard][clipboard] = true;
				q.offer(new Emoticon(screen + clipboard, clipboard, cnt + 1));
			}

			if (screen > 1 && !v[screen - 1][clipboard]) {
				v[screen - 1][clipboard] = true;
				q.offer(new Emoticon(screen - 1, clipboard, cnt + 1));
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