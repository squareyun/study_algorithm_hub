import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = 0;
            int end = 0;
            for (int j = 0; j < 2; j++) {
                int h = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                if(j == 0) start = h * 3600 + m * 60 + s;
                else end = h * 3600 + m * 60 + s;
            }
            int diff = end - start;
            System.out.printf("%d %d %d\n", diff / 3600, (diff % 3600) / 60, (diff % 3600) % 60);
        }
    }

}