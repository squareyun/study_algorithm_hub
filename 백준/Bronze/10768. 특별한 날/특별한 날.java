import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        if (a == 2) {
            if (b == 18)
                System.out.println("Special");
            else if (b < 18)
                System.out.println("Before");
            else
                System.out.println("After");
        } else if (a < 2) {
            System.out.println("Before");
        } else {
            System.out.println("After");
        }

    }

}