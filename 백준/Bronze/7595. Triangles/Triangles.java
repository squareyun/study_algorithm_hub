import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        StringBuilder sb = new StringBuilder();
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            for (int j = 1; j <= n; j++) {
                sb.append("*".repeat(j)).append("\n");
            }
        }
        System.out.println(sb);
    }

}