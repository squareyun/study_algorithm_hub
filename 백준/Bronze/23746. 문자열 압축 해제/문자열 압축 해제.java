import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String pattern = st.nextToken();
            char key = st.nextToken().charAt(0);
            map.put(key, pattern);
        }

        String compressed = br.readLine();

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st2.nextToken());
        int E = Integer.parseInt(st2.nextToken());

        StringBuilder sb = new StringBuilder();
        for (char c : compressed.toCharArray()) {
            sb.append(map.get(c));
        }

        System.out.println(sb.substring(S - 1, E));
    }
}
