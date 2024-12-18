import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("@@@@@".repeat(N)).append("\n");
        }
        for (int i = 0; i < 5 * N - N; i++) {
            sb.append("@".repeat(N)).append("\n");
        }
        System.out.println(sb);
    }
}