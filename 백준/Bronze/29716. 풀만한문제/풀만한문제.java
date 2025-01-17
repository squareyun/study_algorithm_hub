import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int J = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int ans = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int size = 0;
            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    size += 1;
                } else if (Character.isDigit(c)) {
                    size += 2;
                } else if (Character.isUpperCase(c)) {
                    size += 4;
                } else {
                    size += 2;
                }
            }
            if (J >= size) ans++;
        }
        System.out.println(ans);
    }

}