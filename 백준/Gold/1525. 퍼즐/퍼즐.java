import java.util.*;
import java.io.*;

public class Main {

    static String GOAL = "123456789";
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder start = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                String s = st.nextToken();
                start.append(s.equals("0") ? "9" : s);
            }
        }

        System.out.println(bfs(start.toString()));

    }

    static int bfs(String start) {
        if (start.equals(GOAL))
            return 0;

        Queue<String> q = new ArrayDeque<>();
        Map<String, Integer> dist = new HashMap<>();
        q.add(start);
        dist.put(start, 0);

        while (!q.isEmpty()) {
            String cur = q.poll();
            int v = dist.get(cur);
            int idx = cur.indexOf('9');
            int x = idx / 3;
            int y = idx % 3;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3)
                    continue;

                char[] arr = cur.toCharArray();
                int nIdx = nx * 3 + ny;
                char tmp = arr[nIdx];

                arr[nIdx] = '9';
                arr[idx] = tmp;
                String next = new String(arr);

                if (!dist.containsKey(next)) {
                    if (next.equals(GOAL))
                        return v + 1;

                    dist.put(next, v + 1);
                    q.add(next);
                }

            }
        }

        return -1;
    }

}