import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int tot = 0;
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = sc.nextInt();
            tot += arr[i];
        }
        int K = sc.nextInt();

        double bunja = 0;
        for (int i = 0; i < M; i++) {
            bunja += calComb(arr[i], K);
        }

        double bunmo = calComb(tot, K);

        System.out.println(bunja / bunmo);

    }

    static double calComb(int n, int r) {
        double ret = 1;

        for (int i = 0; i < r; i++) {
            ret *= (n--);
        }

        return ret / (factorial(r));
    }

    static double factorial(int n) {
        if (n == 0) {
            return 1;
        }

        double ret = 1;
        for (int i = 2; i <= n; i++) {
            ret *= i;
        }

        return ret;
    }
}