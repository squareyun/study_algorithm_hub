import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++)
            arr[i] = br.readLine();

        Arrays.sort(arr, (a, b) -> {
            if (a.length() != b.length())
                return a.length() - b.length();

            int da = digitSum(a);
            int db = digitSum(b);

            if (da != db)
                return da - db;

            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : arr)
            sb.append(s).append('\n');
        System.out.print(sb);
    }


    private static int digitSum(String s) {
        int sum = 0;

        for (char ch : s.toCharArray())
            if (ch >= '0' && ch <= '9')
                sum += ch - '0';

        return sum;
    }
}
