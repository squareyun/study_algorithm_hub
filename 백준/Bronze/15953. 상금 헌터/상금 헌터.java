import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int prize1 = 0;
            if      (1 <= a && a <=   1) prize1 = 500;
            else if (2 <= a && a <=   3) prize1 = 300;
            else if (4 <= a && a <=   6) prize1 = 200;
            else if (7 <= a && a <=  10) prize1 =  50;
            else if (11 <= a && a <= 15) prize1 =  30;
            else if (16 <= a && a <= 21) prize1 =  10;

            int prize2 = 0;
            if      (1 <= b && b <=   1) prize2 = 512;
            else if (2 <= b && b <=   3) prize2 = 256;
            else if (4 <= b && b <=   7) prize2 = 128;
            else if (8 <= b && b <=  15) prize2 =  64;
            else if (16 <= b && b <= 31) prize2 =  32;

            sb.append((prize1 + prize2) * 10_000).append('\n');
        }

        System.out.print(sb);
    }
}
