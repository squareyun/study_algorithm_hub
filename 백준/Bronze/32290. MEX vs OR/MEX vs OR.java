import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = br.readLine().split(" ");
        int l = Integer.parseInt(parts[0]);
        int r = Integer.parseInt(parts[1]);
        int c = Integer.parseInt(parts[2]);

        int len = r - l + 1;
        int[] arr = new int[len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            arr[i] = (l + i) | c;
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        boolean[] seen = new boolean[max + 2];
        for (int x : arr) {
            if (x < seen.length) {
                seen[x] = true;
            }
        }

        int mex = 0;
        while (seen[mex]) {
            mex++;
        }
        System.out.println(mex);
    }
}
