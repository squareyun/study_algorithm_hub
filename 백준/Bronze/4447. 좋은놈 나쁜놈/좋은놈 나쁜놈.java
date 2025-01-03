import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int g = 0, b = 0;
            for (char c : s.toLowerCase().toCharArray()) {
                if (c == 'g') g++;
                else if (c == 'b') b++;
            }
            sb.append(s).append(" is ");
            if (g == b)
                sb.append("NEUTRAL");
            else if (g > b)
                sb.append("GOOD");
            else
                sb.append("A BADDY");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}