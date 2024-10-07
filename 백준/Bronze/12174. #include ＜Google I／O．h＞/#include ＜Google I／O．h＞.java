import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			sb.append("Case #").append(t).append(": ");

			int B = Integer.parseInt(br.readLine());
			String s = br.readLine();
			s = s.replace('O', '0');
			s = s.replace('I', '1');
			for (int i = 0; i < B; i++) {
				sb.append((char) Integer.parseInt(s.substring(i * 8, i * 8 + 8), 2));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}