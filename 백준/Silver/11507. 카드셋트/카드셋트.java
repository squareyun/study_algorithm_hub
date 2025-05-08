import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        HashMap<Character, HashSet<Integer>> hm = new HashMap<>();
        hm.put('P', new HashSet<>());
        hm.put('K', new HashSet<>());
        hm.put('H', new HashSet<>());
        hm.put('T', new HashSet<>());

        for (int i = 0; i <= s.length() - 3; i += 3) {
            char shape = s.charAt(i);
            int num = Integer.parseInt(s.substring(i + 1, i + 3));

            if (hm.get(shape).contains(num)) {
                System.out.println("GRESKA");
                return;
            } else {
                hm.get(shape).add(num);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(13 - hm.get('P').size()).append(" ");
        sb.append(13 - hm.get('K').size()).append(" ");
        sb.append(13 - hm.get('H').size()).append(" ");
        sb.append(13 - hm.get('T').size());
        System.out.println(sb);
    }
}
