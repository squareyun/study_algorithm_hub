import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int min = 101;
        for (int i = 0; i < 4; i++) {
            int cur = Integer.parseInt(br.readLine());
            sum += cur;
            min = Math.min(min, cur);
        }
        int ans = sum - min;
        ans += Math.max(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
        System.out.println(ans);
    }

}