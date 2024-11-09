import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    static Map<Integer, BigInteger> memo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int k;
        for (int i = 0; i < n; i++) {
            k = Integer.parseInt(br.readLine());
            sb.append("=".repeat(k));
            sb.append("\n");
        }
        System.out.println(sb);
    }

}