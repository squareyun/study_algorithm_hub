import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();
        int idx = name.indexOf('(');

        if (idx == -1) {
            System.out.println(name);
            System.out.println("-");
        } else {
            String station = name.substring(0, idx);

            String alt = name.substring(idx + 1, name.length() - 1);

            System.out.println(station);
            System.out.println(alt);
        }
    }
}
