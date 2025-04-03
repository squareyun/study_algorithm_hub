import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            boolean[] v = new boolean[N];

            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'Y') {
                    v[j] = true;

                    for (int k = 0; k < N; k++) {
                        if (map[j][k] == 'Y')
                            v[k] = true;
                    }
                }
            }

            v[i] = false;
            int cnt = 0;
            for (boolean vv : v) {
                if (vv) cnt++;
            }

            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }

}