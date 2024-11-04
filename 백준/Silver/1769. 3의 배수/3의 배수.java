import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String x = br.readLine();
		int ans = 0;
		while (x.length() != 1) {
			long y = 0 ;
			for (char c : x.toCharArray()) {
				y += (c - '0');
			}
			ans++;
			x = String.valueOf(y);
		}
		System.out.println(ans);
		System.out.println((Integer.parseInt(x) % 3 == 0) ? "YES" : "NO");
	}

}