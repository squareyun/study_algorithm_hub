import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("\\.");
            hm.put(s[1], hm.getOrDefault(s[1], 0) + 1);
        }
        List<String> name = new ArrayList<>();
        for (String s : hm.keySet())
            name.add(s);
        Collections.sort(name);
        StringBuilder sb = new StringBuilder();
        for (String s : name) {
            sb.append(s).append(" ").append(hm.get(s)).append("\n");
        }
        System.out.println(sb);
    }
}