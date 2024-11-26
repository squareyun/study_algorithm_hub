import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringBuilder sb = new StringBuilder();
        while (!(s = br.readLine()).equals("# 0 0")) {
            String[] split = s.split(" ");
            boolean isSenior = false;
            if (Integer.parseInt(split[1]) > 17 || Integer.parseInt(split[2]) >= 80)
                isSenior = true;
            sb.append(split[0]).append(" ");
            sb.append(isSenior ? "Senior" : "Junior");
            sb.append("\n");
        }
        System.out.println(sb);
    }

}