import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        if (x > 0) {
            System.out.println((y > 0) ? 1 : 4);
        } else if (x < 0) {
            System.out.println((y > 0) ? 2 : 3);
        }
    }
}