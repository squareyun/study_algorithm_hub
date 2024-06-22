import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i);
			String ascii = String.valueOf(c);
			int cnt = 0;
			for (int j = 0; j < ascii.length(); j++) {
				cnt += ascii.charAt(j) - '0';
			}
			for (int j = 0; j < cnt; j++) {
				sb.append((char) c);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}