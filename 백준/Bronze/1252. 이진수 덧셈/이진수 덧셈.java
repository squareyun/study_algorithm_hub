import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        BigInteger ba = new BigInteger(a, 2);
        BigInteger bb = new BigInteger(b, 2);
        String result = ba.add(bb).toString(2);

        System.out.println(result);
    }
}
