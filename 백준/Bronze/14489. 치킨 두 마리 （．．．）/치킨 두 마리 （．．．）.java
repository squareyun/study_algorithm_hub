import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(br.readLine());
        if (a + b >= 2 * c) {
            System.out.println(a + b - 2 * c);
        } else {
            System.out.println(a + b);
        }
    }

}