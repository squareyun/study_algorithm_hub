import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] x = new int[N];
        int[] y = new int[N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        long total = 0;
        for (int i = 0; i < N - 1; i++) {
            total += Math.abs(x[i+1] - x[i])
                    + Math.abs(y[i+1] - y[i]);
        }

        long maxSave = 0;
        for (int i = 1; i < N - 1; i++) {
            long original = Math.abs(x[i]   - x[i-1])
                    + Math.abs(y[i]   - y[i-1])
                    + Math.abs(x[i+1] - x[i])
                    + Math.abs(y[i+1] - y[i]);

            long skip = Math.abs(x[i+1] - x[i-1])
                    + Math.abs(y[i+1] - y[i-1]);

            long save = original - skip;
            if (save > maxSave) {
                maxSave = save;
            }
        }

        System.out.println(total - maxSave);
    }
}
