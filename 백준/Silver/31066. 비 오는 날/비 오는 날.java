import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (m == 1 && k == 1) {
                sb.append(n == 1 ? 1 : -1).append('\n');
                continue;
            }

            int dest = 0;
            boolean toB = true;
            int moves = 0;

            while (dest < n) {
                if (toB) {
                    dest += m * k;
                } else {
                    dest -= 1;
                }
                moves++;
                toB = !toB;
            }

            sb.append(moves).append('\n');
        }

        System.out.print(sb);
    }
}
