import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String yeondu = br.readLine();

        int N = Integer.parseInt(br.readLine());

        String[] candidates = new String[N];
        for (int i = 0; i < N; i++) {
            candidates[i] = br.readLine();
        }

        int[] baseCount = new int[4];  // index 0='L', 1='O', 2='V', 3='E'
        for (int i = 0; i < yeondu.length(); i++) {
            char c = yeondu.charAt(i);
            if (c == 'L') baseCount[0]++;
            else if (c == 'O') baseCount[1]++;
            else if (c == 'V') baseCount[2]++;
            else if (c == 'E') baseCount[3]++;
        }

        Arrays.sort(candidates);

        int bestScore = -1;
        String bestName = "";

        for (String team : candidates) {
            int[] cnt = Arrays.copyOf(baseCount, 4);

            for (int i = 0; i < team.length(); i++) {
                char c = team.charAt(i);
                if (c == 'L') cnt[0]++;
                else if (c == 'O') cnt[1]++;
                else if (c == 'V') cnt[2]++;
                else if (c == 'E') cnt[3]++;
            }

            int L = cnt[0], O = cnt[1], V = cnt[2], E = cnt[3];
            int score = ((L + O) * (L + V) * (L + E)
                       * (O + V) * (O + E) * (V + E)) % 100;

            if (score > bestScore) {
                bestScore = score;
                bestName = team;
            }
        }

        System.out.println(bestName);
    }
}
