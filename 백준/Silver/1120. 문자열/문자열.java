import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();
		int aLen = A.length();
		int bLen = B.length();

		if (aLen == bLen) {
			System.out.println(diff(A, B));
			return;
		}

		int ans = 51;
		for (int i = 0; i < bLen - aLen + 1; i++) {
			// System.out.println(i);
			// System.out.println(B.substring(i, i + aLen));
			ans = Math.min(ans, diff(A, B.substring(i, i + aLen)));
			if (ans == 0) break;
		}
		System.out.println(ans);
	}

	static int diff(String A, String B) {
		int cnt = 0;

		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) != B.charAt(i))
				cnt++;
		}

		return cnt;
	}

}