import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    static Map<Integer, BigInteger> memo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (br.readLine().equals(target))
                answer++;
        }
        System.out.println(answer);
    }

}