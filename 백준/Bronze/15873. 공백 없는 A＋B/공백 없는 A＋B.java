import javax.xml.parsers.SAXParser;
import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int sum = 0;
        if (s.startsWith("10")) {
            sum += Integer.parseInt(s.substring(0, 2));
            sum += Integer.parseInt(s.substring(2));
        } else {
            sum += Integer.parseInt(s.substring(0, 1));
            sum += Integer.parseInt(s.substring(1));
        }
        System.out.println(sum);
    }

    

}