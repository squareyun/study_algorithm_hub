import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int J = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int[] boxes = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                boxes[i] = r * c;
            }

            Arrays.sort(boxes);

            int count = 0;
            for (int i = N - 1; i >= 0 && J > 0; i--) {
                J -= boxes[i];
                count++;
            }

            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }
}
