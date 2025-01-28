import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] origin = {1, 1, 2, 2, 2, 8};
        for (int j : origin) {
            System.out.printf("%d ", j - Integer.parseInt(st.nextToken()));
        }
    }

}