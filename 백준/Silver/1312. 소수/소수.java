import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int rem = A % B, digit = 0;
        for (int i = 0; i < N; i++) {
            rem *= 10;
            digit = rem / B;
            rem %= B;
        }
        System.out.println(digit);
    }
}