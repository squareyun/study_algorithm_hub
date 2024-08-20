import java.util.*;
import java.io.*;

public class Main {

	static int[] code = new int[10];
	static HashMap<Integer, Integer> hm = new HashMap<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		makeCode();

		String s;
		StringBuilder ans = new StringBuilder();
		while ( !(s = br.readLine()).equals("BYE")) {
			String aStr = s.substring(0, s.indexOf('+'));
			String bStr = s.substring(s.indexOf('+') + 1, s.length() - 1);

			int a = convert(aStr);
			int b = convert(bStr);
			ans.append(s).append(convert2(a + b)).append("\n");
		}
		System.out.println(ans);

	}

	private static String convert2(int n) {
		StringBuilder ret = new StringBuilder();

		String s = String.valueOf(n);
		for (int i = 0; i < s.length(); i++) {
			int c = code[s.charAt(i) - '0'];
			if (c < 100) {
				ret.append("0").append(c);
			} else {
				ret.append(c);
			}
		}

		return ret.toString();
	}

	private static int convert(String str) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i += 3) {
			int sub = Integer.parseInt(str.substring(i, i + 3));
			sb.append(hm.get(sub));
		}

		return Integer.parseInt(sb.toString());
	}

	private static void makeCode() {
		String[] arr = {
			"0111111", "0001010", "1011101", "1001111", "1101010",
			"1100111", "1110111", "0001011", "1111111", "1101011"
		};

		for (int i = 0; i < 10; i++) {
			int num = Integer.parseInt(arr[i], 2);
			code[i] = num;
			hm.put(num, i);
		}
	}

}