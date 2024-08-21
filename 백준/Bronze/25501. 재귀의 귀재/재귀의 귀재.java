import java.util.*;
import java.io.*;

public class Main {

	static int cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			String s = br.readLine();
			cnt = 1;
			int ret = isPalindrome(s);
			sb.append(ret).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	static int isPalindrome(String s) {
		return recursion(s, 0, s.length() - 1);
	}

	static int recursion(String s, int l, int r) {
		if (l >= r)
			return 1;
		else if (s.charAt(l) != s.charAt(r))
			return 0;
		else {
			cnt++;
			return recursion(s, l + 1, r - 1);
		}
	}

}