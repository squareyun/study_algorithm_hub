import java.util.*;
import java.io.*;

public class Main {

	static String[] s;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine().split(" ");
		int k1 = Integer.parseInt(s[0]);
		int k2 = Integer.parseInt(s[2]);
		int k3 = Integer.parseInt(s[4]);
		String o1 = s[1];
		String o2 = s[3];

		int[] res = new int[2];
		res[0] = calculate(calculate(k1, k2, o1), k3, o2);
		res[1] = calculate((k1), calculate(k2, k3, o2), o1);
		Arrays.sort(res);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}

	static int calculate(int a, int b, String op) {
		switch (op) {
			case "+": return a + b;
			case "-": return a - b;
			case "*": return a * b;
			case "/": return a / b;
		}
		return Integer.MAX_VALUE;
	}

}