import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    static Map<Integer, BigInteger> memo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(fibo(N));
    }

    static BigInteger fibo(int n) {
        if (n <= 2)
            return BigInteger.ONE;

        if (memo.containsKey(n))
            return memo.get(n);

        BigInteger now = fibo(n - 2).add(fibo(n - 1));
        memo.put(n, now);
        return now;
    }

}