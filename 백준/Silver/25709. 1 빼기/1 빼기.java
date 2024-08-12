import java.util.*;
import java.io.*;

public class Main {

	static String N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = br.readLine();

		int ans = 0;
		while (!N.equals("0")) {
			boolean flag = false;
			for (int i = 0; i < N.length(); i++) {
				if (N.length() > 1 && N.charAt(i) == '1') {
					N = N.substring(0, i).concat(N.substring(i + 1));
					N = String.valueOf(Integer.parseInt(N));
					flag = true;
					break;
				}
			}
			if (!flag) {
				N = String.valueOf(Integer.parseInt(N) - 1);
			}
			ans++;
		}
		System.out.println(ans);
	}

}