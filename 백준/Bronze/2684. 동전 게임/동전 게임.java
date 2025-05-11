import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());

        while (P-- > 0) {
            String s = br.readLine();
            int[] cnt = new int[8];

            for (int i = 0; i <= 40 - 3; i++) {
                int idx  = (s.charAt(i)   == 'H' ? 4 : 0)
                         + (s.charAt(i+1) == 'H' ? 2 : 0)
                         + (s.charAt(i+2) == 'H' ? 1 : 0);
                cnt[idx]++;
            }

            for (int j = 0; j < 8; j++) {
                System.out.print(cnt[j] + (j < 7 ? " " : ""));
            }
            System.out.println();
        }
    }
}
