import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        double cur = Double.parseDouble(br.readLine());
        double answer = cur;

        for (int i = 1; i < n; i++) {
            double x = Double.parseDouble(br.readLine());

            cur = Math.max(x, cur * x);
            answer = Math.max(answer, cur);
        }
        System.out.printf("%.3f%n", answer);
    }
}