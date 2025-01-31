import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long sum = 0;
        long a;
        while ((a = Integer.parseInt(br.readLine())) != -1) {
            sum += a;
        }
        System.out.println(sum);
    }

}