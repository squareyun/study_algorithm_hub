import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        for (int i = 2; i <= 9; i++) {
            hs.add(i);
            for (int j = 1; j <= 9; j++) {
                hs.add(i * j);
            }
        }
        int N = Integer.parseInt(br.readLine());
        System.out.println(hs.contains(N) ? 1 : 0);
    }

}