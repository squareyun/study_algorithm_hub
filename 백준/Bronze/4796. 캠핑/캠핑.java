import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int caseNum = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            if (L == 0 && P == 0 && V == 0) break;

            int cycles = V / P;
            int rem = V % P;
            int use = cycles * L + Math.min(L, rem);
            sb.append("Case ").append(caseNum++).append(": ").append(use).append('\n');
        }

        System.out.print(sb);
    }
}