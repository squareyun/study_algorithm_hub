import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = br.readLine()).equals("0 0")) {
            String[] ss = s.split(" ");
            double x = Double.parseDouble(ss[0]);
            double y = Double.parseDouble(ss[1]);
            if (x == 0 || y == 0) {
                System.out.println("AXIS");
            } else if (x > 0) {
                System.out.println((y > 0) ? "Q1" : "Q4");
            } else if (x < 0) {
                System.out.println((y > 0) ? "Q2" : "Q3");
            }
        }
        System.out.println("AXIS");
    }

}