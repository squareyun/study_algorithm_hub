import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int ans = 0;
        if (A % 2 == 1) {
            ans = (int) Math.ceil((double) (B - A) / 2);
            if (B % 2 == 1) ans++;
        } else {
            ans++;
            ans += (int) Math.ceil((double) ((B - (A + 1))) / 2);
            if (B % 2 == 1) ans++;
        }
        System.out.println(ans);
    }
}