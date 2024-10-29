import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String s = br.readLine();
        long H = 0L;
        long pow = 1L;
        for (int i = 0; i < L; i++) {
            H += (s.charAt(i) - 'a' + 1) * pow;
            pow = (pow * 31) % 1234567891;
        }
        System.out.println(H % 1234567891);
    }

}