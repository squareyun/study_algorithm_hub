import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int total = L * P;
        for (int i = 0; i < 5; i++) {
            sb.append(Integer.parseInt(st.nextToken()) - total);
            sb.append(" ");
        }
        System.out.println(sb);
    }

}