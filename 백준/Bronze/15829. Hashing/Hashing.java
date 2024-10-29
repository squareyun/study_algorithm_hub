import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String s = br.readLine();
        long H = 0L;
        for (int i = 0; i < L; i++) {
            H += (s.charAt(i) - 'a' + 1) * (long) Math.pow(31, i);
        }
        System.out.println(H);
    }

}