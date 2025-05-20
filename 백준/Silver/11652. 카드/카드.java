import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeMap<Long, Integer> countMap = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            long x = Long.parseLong(br.readLine());
            countMap.put(x, countMap.getOrDefault(x, 0) + 1);
        }

        long most = 0;
        int maxCount = 0;
        for (Map.Entry<Long, Integer> entry : countMap.entrySet()) {
            int c = entry.getValue();
            long card = entry.getKey();

            if (c > maxCount) {
                maxCount = c;
                most = card;
            }
        }

        System.out.println(most);
    }
}
