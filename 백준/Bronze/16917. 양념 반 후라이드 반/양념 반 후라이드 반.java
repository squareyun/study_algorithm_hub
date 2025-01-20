import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int minXY = Math.min(X, Y);

        long ans = 0;

        if (2 * C < (A + B)) {
            ans = (long) 2 * C * minXY;
        } else {
            ans = (long) (A + B) * minXY;
        }

        if (minXY == X) {
            int remain = Y - minXY;
            ans += Math.min(remain * B, 2 * C * remain);
        } else {
            int remain = X - minXY;
            ans += Math.min(remain * A, 2 * C * remain);
        }

        System.out.println(ans);
    }

}