import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = Integer.parseInt(st.nextToken());
        int diff = Integer.parseInt(st.nextToken());
        if ((sum + diff) % 2 != 0 || sum < diff) {
            System.out.println(-1);
        } else {
            int a = (sum + diff) / 2;
            int b = a - diff;
            System.out.printf("%d %d\n", a, b);
        }
    }

}