import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }

        int len = 1;
        int cnt = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                len++;
            } else {
                if (len == 3)
                    cnt++;
                len = 1;
            }
        }

        if (len == 3)
            cnt++;

        System.out.println(cnt);
    }

}