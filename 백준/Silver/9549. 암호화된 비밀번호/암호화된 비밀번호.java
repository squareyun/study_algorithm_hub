import java.util.*;
import java.io.*;

public class Main {

	static int T;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			String encrypt = br.readLine();
			String origin = br.readLine();

			int[] originAlpha = new int[26];
			for (char c : origin.toCharArray()) {
				originAlpha[c - 'a']++;
			}

			int[] encryptAlpha = new int[26];
			for (char c : encrypt.substring(0, origin.length()).toCharArray()) {
				encryptAlpha[c - 'a']++;
			}

			boolean find = false;
			for (int i = 0; i <= encrypt.length() - origin.length(); i++) {
				if (i == 0) {
					if (check(originAlpha, encryptAlpha)) {
						find = true;
						break;
					}
					continue;
				}

				encryptAlpha[encrypt.charAt(i - 1) - 'a']--;
				encryptAlpha[encrypt.charAt(i + origin.length() - 1) - 'a']++;
				if (check(originAlpha, encryptAlpha)) {
					find = true;
					break;
				}
			}

			if (find) sb.append("YES");
			else sb.append("NO");
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static boolean check(int[] originAlpha, int[] encryptAlpha) {
		for (int i = 0; i < originAlpha.length; i++) {
			if (originAlpha[i] != encryptAlpha[i]) return false;
		}
		return true;
	}

}