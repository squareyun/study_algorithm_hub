import java.util.Scanner;

public class Main {

    static int A, B, C, N, R;
    static int[] arr, brr;
    static boolean[] v;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String inputA = input.split(" ")[0];
        String inputB = input.split(" ")[1];
        A = Integer.parseInt(inputA);
        B = Integer.parseInt(inputB);
        C = -1;
        N = inputA.length();
        R = inputA.length();
        arr = new int[N];
        brr = new int[N];
        v = new boolean[N];

        for (int i = 0; i < R; i++) {
            arr[i] = inputA.charAt(i) - '0';
        }

        dfs(0);

        System.out.println(C);
    }

    static void dfs(int cur) {
        if (cur == R) {
            if (brr[0] == 0) {
                return;
            }
            
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < R; i++) {
                sb.append(brr[i]);
            }

            int curC = Integer.parseInt(sb.toString());

            if (curC < B) {
                C = Math.max(curC, C);
            }

            return;
        }

        for (int i = 0; i < N; i++) {
            if (v[i]) continue;

            v[i] = true;
            brr[cur] = arr[i];
            dfs(cur + 1);
            v[i] = false;
        }
    }
}