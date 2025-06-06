import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long m = (long)Math.floor(Math.sqrt(n));
        long i;
        if (m * m >= n) {
            i = 2 * m - 1;
        } else if (m * (m + 1) >= n) {
            i = 2 * m;
        } else {
            i = 2 * m + 1;
        }
        long total;
        if ((i & 1) == 0) {
            long t = i / 2;
            total = t * (t + 1);
        } else {
            long t = (i + 1) / 2;
            total = t * t;
        }
        long overshoot = total - n;
        long accX = 0, accY = 0;
        for (long j = 1; j < i; j++) {
            long steps = (j + 1) / 2;
            int dir = (int)((j - 1) % 4);
            if (dir == 0) accY += steps;
            else if (dir == 1) accX += steps;
            else if (dir == 2) accY -= steps;
            else accX -= steps;
        }
        long full = (i + 1) / 2;
        long actual = full - overshoot;
        int dirI = (int)((i - 1) % 4);
        if (dirI == 0) accY += actual;
        else if (dirI == 1) accX += actual;
        else if (dirI == 2) accY -= actual;
        else accX -= actual;
        System.out.println(accX + " " + accY);
    }
}
