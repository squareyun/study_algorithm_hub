import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int ans = 0;
        if (arr[0] == arr[1] && arr[1] == arr[2])
            ans = 10_000 + arr[0] * 1_000;
        else if (arr[0] == arr[1])
            ans = 1_000 + arr[0] * 100;
        else if (arr[1] == arr[2])
            ans = 1_000 + arr[1] * 100;
        else
            ans = arr[2] * 100;

        System.out.println(ans);
    }
}