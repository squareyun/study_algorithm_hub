import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine()) != null) {
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                switch (arr[i]) {
                    case 'i':
                        arr[i] = 'e';
                        break;
                    case 'e':
                        arr[i] = 'i';
                        break;
                    case 'I':
                        arr[i] = 'E';
                        break;
                    case 'E':
                        arr[i] = 'I';
                }
                sb.append(arr[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}