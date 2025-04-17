import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long sx = Long.parseLong(st.nextToken()), sy = Long.parseLong(st.nextToken());
        long ex = Long.parseLong(st.nextToken()), ey = Long.parseLong(st.nextToken());

        long bestDist = Long.MAX_VALUE;
        int bestIdx = 1;

        for (int i = 1; i <= N; i++) {
            int K = Integer.parseInt(br.readLine().trim());
            long dist = 0;
            long px = sx, py = sy;

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                long x = Long.parseLong(st.nextToken());
                long y = Long.parseLong(st.nextToken());
                dist += Math.abs(px - x) + Math.abs(py - y);
                px = x; py = y;
            }

            dist += Math.abs(px - ex) + Math.abs(py - ey);

            if (dist < bestDist) {
                bestDist = dist;
                bestIdx = i;
            }
        }

        System.out.println(bestIdx);
    }
}