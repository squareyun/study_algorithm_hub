import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < 5; j++) {
                max = Math.max(max, Integer.parseInt(st.nextToken()));
            }
            sb.append("Case #").append(i).append(": ").append(max).append("\n");
        }
        System.out.println(sb);
    }

}