import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringBuilder sb = new StringBuilder();
        while (!(s = br.readLine()).equals("#")) {
            char target = s.charAt(0);
            s = s.substring(2);
            int cnt = 0;
            for (char c : s.toLowerCase().toCharArray()) {
                if (c == target)
                    cnt++;
            }
            sb.append(target).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }

}