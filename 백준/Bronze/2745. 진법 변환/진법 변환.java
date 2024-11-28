import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        int p = 0;
        int ans = 0;
        for (int i = N.length() - 1; i >= 0; i--) {
            int a = 0;
            if (Character.isDigit(N.charAt(i))) {
                a = N.charAt(i) - '0';
            } else {
                a = N.charAt(i) - 'A' + 10;
            }
            ans += a * (int) Math.pow(B, p++);
        }
        System.out.println(ans);
    }

}