import java.util.*;
import java.io.*;

public class Main {

	static int T;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			String encrypted = br.readLine();
			String origin = br.readLine();
			boolean result = solve(origin, encrypted);
			sb.append(result ? "YES" : "NO").append("\n");
		}
		System.out.println(sb);
	}

	private static boolean solve(String origin, String encrypted) {

		int lenOrigin = origin.length();
		int lenEncrypted = encrypted.length();

		int[] cntOrigin = new int[26];
		for (int i = 0; i < lenOrigin; i++) {
			cntOrigin[origin.charAt(i) - 'a']++;
		}

		int[] cntEncrypted = new int[26];
		for (int i = 0; i < lenOrigin; i++) {
			cntEncrypted[encrypted.charAt(i) - 'a']++;
		}

		if (Arrays.equals(cntOrigin, cntEncrypted))
			return true;

		for (int i = lenOrigin; i < lenEncrypted; i++) {
			cntEncrypted[encrypted.charAt(i) - 'a']++;
			cntEncrypted[encrypted.charAt(i - lenOrigin) - 'a']--;
			if (Arrays.equals(cntOrigin, cntEncrypted))
				return true;
		}

		return false;
	}
}