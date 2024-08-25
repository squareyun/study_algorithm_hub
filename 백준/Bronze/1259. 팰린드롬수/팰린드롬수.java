import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		StringBuilder sb = new StringBuilder();
		while (!(s = br.readLine()).equals("0")) {
			int l = 0, r = s.length() - 1;
			boolean flag = true;
			while (l <= r) {
				if (s.charAt(l++) != s.charAt(r--)) {
					flag = false;
					break;
				}
			}
			if (flag)
				sb.append("yes");
			else
				sb.append("no");
			sb.append("\n");
		}
		System.out.println(sb);
	}

}