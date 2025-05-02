import java.io.*;
import java.util.*;

public class Main {

    private static final int[] NEED = { 8, 8, 4, 1, 9 };  // 우유, 노른자, 설탕, 소금, 밀가루

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            br.readLine();
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            long[] stock = new long[5];
            for (int i = 0; i < 5; i++)
                stock[i] = Long.parseLong(st1.nextToken());

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            long banana  = Long.parseLong(st2.nextToken());
            long jam     = Long.parseLong(st2.nextToken());
            long choco   = Long.parseLong(st2.nextToken());
            long walnut  = Long.parseLong(st2.nextToken());

            long byBatter = Long.MAX_VALUE;

            for (int i = 0; i < 5; i++) {
                long possible = stock[i] * 16 / NEED[i];
                byBatter = Math.min(byBatter, possible);
            }

            long byTopping = banana
                    + jam   / 30
                    + choco / 25
                    + walnut / 10;

            sb.append(Math.min(byBatter, byTopping)).append('\n');
        }

        System.out.print(sb);
    }
}
