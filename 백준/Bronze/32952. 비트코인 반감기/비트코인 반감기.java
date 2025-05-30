import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long R = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long h = M / K;

        if (h == 0) {
            System.out.println(R);
            return;
        }

        int bitLen = 64 - Long.numberOfLeadingZeros(R);
        if (h >= bitLen) {
            System.out.println(0);
        } else {
            System.out.println(R >> h);
        }
    }
}
