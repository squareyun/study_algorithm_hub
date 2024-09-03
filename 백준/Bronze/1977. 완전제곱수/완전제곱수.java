import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		int sum = -1;
		int min = Integer.MIN_VALUE;
		for (int i = 1; i * i <= N; i++) {
			if (i * i >= M) {
				if (sum == -1) {
					min = i * i;
					sum = 0;
				}
				sum += i * i;
			}
		}
		System.out.println(sum);
		if (sum != -1) {
			System.out.println(min);
		}
	}

}