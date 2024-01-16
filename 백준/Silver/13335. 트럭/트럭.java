import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Queue<Integer> truck = new ArrayDeque<>();
        Queue<Integer> bridge = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck.offer(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < w; i++) {
            bridge.offer(0);
        }

        int answer = 0;
        int bridgeWeight = 0;
        while (!bridge.isEmpty()) {
            bridgeWeight -= bridge.poll();

            if (!truck.isEmpty()) {
                if (bridgeWeight + truck.peek() <= L) {
                    int cur = truck.poll();
                    bridgeWeight += cur;
                    bridge.offer(cur);
                } else {
                    bridge.offer(0);
                }
            }

            answer++;
        }
        System.out.println(answer);
    }
}