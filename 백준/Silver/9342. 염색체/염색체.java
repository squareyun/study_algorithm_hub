import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String regex = "[A-F]?A+F+C+[A-F]?$";
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            sb.append(br.readLine().matches(regex) ? "Infected!" : "Good");
            sb.append("\n");
        }
        System.out.println(sb);
    }

}