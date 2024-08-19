import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static char[] S;
	static ArrayList<Character> ans = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new char[N];
		for (int i = 0; i < N; i++) {
			S[i] = br.readLine().charAt(0);
		}

		int l = 0, r = N - 1;
		while (l <= r) {
			if (S[l] < S[r])
				ans.add(S[l++]);
			else if (S[l] > S[r])
				ans.add(S[r--]);
			else {
				int ll = l, rr = r;
				boolean left = false;

				while (S[ll] == S[rr]) {
					if (rr > 0) rr--;
					if (ll < N - 1) ll++;

					if (S[ll] < S[rr]) left = true;
					else if (S[ll] > S[rr]) left = false;
				}

				if (left)
					ans.add(S[l++]);
				else
					ans.add(S[r--]);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ans.size(); i++) {
			sb.append(ans.get(i));
			if ((i + 1) % 80 == 0)
				sb.append("\n");
		}
		System.out.println(sb);
	}

}