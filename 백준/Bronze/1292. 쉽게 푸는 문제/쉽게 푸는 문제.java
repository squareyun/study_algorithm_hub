import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] seq = new int[1001];
        int idx = 1;
        for (int i = 1; idx <= 1000; i++) {
            for (int k = 0; k < i && idx <= 1000; k++) {
                seq[idx++] = i;
            }
        }

        int sum = 0;
        for (int i = A; i <= B; i++)
            sum += seq[i];
        
        System.out.println(sum);
    }
}
