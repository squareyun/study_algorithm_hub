import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        HashSet<String> hs = new HashSet<>();
        br.readLine();

        for (int i = 1; i < N; i++) {
            String s = br.readLine();

            if (s.equals("ENTER")) {
                cnt += hs.size();
                hs = new HashSet<>();
            } else {
                hs.add(s);
            }
        }
        cnt += hs.size();

        System.out.println(cnt);
    }

}