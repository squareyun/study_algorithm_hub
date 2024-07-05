import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static String s;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		s = br.readLine();

		if (N <= 2) {
			System.out.println(1);
			return;
		}


		for (int i = 0; i < N; i++) {
			if ((i + 3 == N) || (i + 3 < N && s.charAt(i + 3) != '0')) {
				if (Integer.parseInt(s.substring(i, i + 3)) <= 641) {
					i += 2;
				}
			}
			else if ((i + 2 == N) || (i + 2 < N && s.charAt(i + 2) != '0')) {
				if (Integer.parseInt(s.substring(i, i + 2)) <= 641) {
					i += 1;
				}
			}
			ans++;
		}
		System.out.println(ans);
	}
}