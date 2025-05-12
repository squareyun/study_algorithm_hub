import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] maxStreaks = new int[N];
        String[] names     = new String[N];
        Set<Integer> unique = new HashSet<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            int tmp = 0, max = 0;

            for (int j = 0; j < M; j++) {
                if (line.nextToken().equals(".")) {
                    tmp++;
                    if (tmp > max) max = tmp;
                } else {
                    tmp = 0;
                }
            }

            names[i]       = line.nextToken();
            maxStreaks[i]  = max;
            unique.add(max);
        }

        System.out.println(unique.size());
        for (int i = 0; i < N; i++) {
            System.out.println(maxStreaks[i] + " " + names[i]);
        }
    }
}
