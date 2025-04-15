import java.math.BigInteger;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            String line;
            while ((line = br.readLine()) != null && line.trim().isEmpty()) {
            }

            int N = Integer.parseInt(line.trim());
            BigInteger sum = BigInteger.ZERO;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    sum = sum.add(new BigInteger(st.nextToken()));
                }
            }
            
            if (sum.mod(BigInteger.valueOf(N)).equals(BigInteger.ZERO)) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.print(sb);
    }
}
