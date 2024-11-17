import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.equals("P=NP")) {
                sb.append("skipped");
            } else {
                String[] sub = s.split("\\+");
                sb.append(Integer.parseInt(sub[0]) + Integer.parseInt(sub[1]));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}