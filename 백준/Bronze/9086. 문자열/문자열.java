import java.util.*;
	import java.io.*;

	public class Main {

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < T; i++) {
				String s = br.readLine();
				sb.append(s.charAt(0)).append(s.charAt(s.length() - 1)).append("\n");
			}
			System.out.println(sb);
		}

	}