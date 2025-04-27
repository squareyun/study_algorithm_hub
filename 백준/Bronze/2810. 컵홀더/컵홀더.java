import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String seats = br.readLine();

        int couple = 0;
        for (int i = 0; i < N - 1; i++) {
            if (seats.charAt(i) == 'L' && seats.charAt(i + 1) == 'L') {
                couple++;
                i++;
            }
        }
        int cup = N + 1 - couple;
        System.out.println(Math.min(N, cup));
    }
}
