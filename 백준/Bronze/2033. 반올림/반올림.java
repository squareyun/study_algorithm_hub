import javax.xml.parsers.SAXParser;
import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] crr = br.readLine().toCharArray();
        int add = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = crr.length - 1; i > 0; i--) {
            int num = crr[i] - '0';
            int nowNum = num + add;
            add = nowNum >= 5 ? 1 : 0;
            sb.append(0);
        }
        sb.insert(0, crr[0] - '0' + add);
        System.out.println(sb);
    }

    

}