import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long b = Long.parseLong(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Long> priceMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            long price = Long.parseLong(st.nextToken());
            priceMap.put(name, price);
        }

        long sum = 0;
        for (int i = 0; i < m; i++) {
            String want = br.readLine();
            sum += priceMap.get(want);
        }

        System.out.println(sum > b ? "unacceptable" : "acceptable");
    }
}
