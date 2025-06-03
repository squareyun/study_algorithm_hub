import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            int baseTime = K / A;

            int fullCycles = K / (A * t);
            if (K % (A * t) == 0) {
                fullCycles--;
            }

            int totalTime = baseTime + fullCycles * s;

            if (totalTime < answer) {
                answer = totalTime;
            }
        }

        System.out.println(answer);
    }
}
