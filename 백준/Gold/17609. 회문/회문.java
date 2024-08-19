import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			String s = br.readLine();

			if (palindrome(s))
				sb.append(0);
			else if (pseudonym(s))
				sb.append(1);
			else
				sb.append(2);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static boolean palindrome(String s) {
		int l = 0, r = s.length() - 1;
		while (l <= r) {
			if (s.charAt(l++) != s.charAt(r--)) {
				return false;
			}
		}
		return true;
	}

	static boolean pseudonym(String s) {
		int l = 0, r = s.length() - 1;
		while (l <= r) {
			if (s.charAt(l) != s.charAt(r)) {
				return palindrome(s.substring(l, r)) || palindrome(s.substring(l + 1, r + 1));
			}
			l++;
			r--;
		}
		return true;
	}

}