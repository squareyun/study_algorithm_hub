import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static String S;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		S = br.readLine();

		int ans = 0;
		int count = 0;
		for (int i = 0; i + 2 < M; i++) {
			// IOI 패턴
			if (S.charAt(i) == 'I' && S.charAt(i + 1) == 'O' && S.charAt(i + 2) == 'I') {
				count++;
				i += 1;

				if (count == N) {
					ans++;
					count--;
				}
			} else
				count = 0;
		}
		System.out.println(ans);
	}

}