import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            for (int i = 0; i < H; i++) {
                String s = br.readLine();
                for (int j = s.length() - 1; j >= 0; j--) {
                    sb.append(s.charAt(j));
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}