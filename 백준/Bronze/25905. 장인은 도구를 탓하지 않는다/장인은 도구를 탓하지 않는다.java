import java.util.*;
	import java.io.*;

	public class Main {

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			double[] arr = new double[10];
			double min = 1;
			for (int i = 0; i < 10; i++) {
				arr[i] = Double.parseDouble(br.readLine());
				min = Math.min(min, arr[i]);
			}
			double ans = 1;
			for (int i = 0; i < 10; i++) {
				ans *= arr[i];
			}
			ans /= min;
			for (int i = 1; i <= 9; i++) {
				ans /= i;
			}
			ans *= 10e8;
			if (Math.ceil(ans) == ans) {
				System.out.printf("%.0f\n", ans);
			} else {
				System.out.printf("%.6f\n", ans);
			}
		}

	}