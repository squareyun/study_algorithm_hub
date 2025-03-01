import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double n;
        while ((n = Double.parseDouble(br.readLine())) != 0) {
            System.out.printf("%.2f\n", 1 + n + Math.pow(n, 2) + Math.pow(n, 3) + Math.pow(n, 4));
        }
    }

}