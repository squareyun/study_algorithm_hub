import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int[] memo = new int[1000001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int index = 1;
		for (int i = 1; index < 1000001; i++) {
			if (valid(i)) {
				memo[index] = i;
				index++;
			}
		}

		StringBuilder sb = new StringBuilder();
		while ( (n = Integer.parseInt(br.readLine())) != 0) {
			sb.append(memo[n]).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean valid(int num) {
		int bitMask = 0;
		int digit;
		while (num > 0) {
			digit = num % 10;
			if ((bitMask & (1 << digit)) != 0) return false;
			bitMask |= (1 << digit);
			num /= 10;
		}
		return true;
	}

}