import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long X = Long.parseLong(br.readLine());
        int N = Integer.parseInt(br.readLine());
        long ans = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ans += (long) Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        }
        if (ans == X) System.out.println("Yes");
        else System.out.println("No");
    }

}