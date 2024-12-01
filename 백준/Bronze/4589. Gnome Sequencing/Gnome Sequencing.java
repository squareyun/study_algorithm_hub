import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("Gnomes:\n");
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            for (int j = 0; j < 3; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            boolean increase = false;
            if (arr[0] < arr[1])
                increase = true;

            boolean ordered = false;
            if (increase && (arr[1] < arr[2]))
                ordered = true;
            if (!increase && (arr[1] > arr[2]))
                ordered = true;

            sb.append(ordered ? "Ordered" : "Unordered");
            sb.append("\n");
        }
        System.out.println(sb);
    }

}