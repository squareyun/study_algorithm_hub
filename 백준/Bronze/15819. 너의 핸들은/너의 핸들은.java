import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int I = Integer.parseInt(st.nextToken());

        String[] handles = new String[N];
        for (int i = 0; i < N; i++) {
            handles[i] = br.readLine();
        }

        Arrays.sort(handles);

        System.out.println(handles[I - 1]);
    }
}
