import java.util.*;
import java.io.*;

public class Main {

	static char[][] key = {{'`', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '='},
		{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', '[', ']', '\\'},
		{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ';', '\''},
		{'z', 'x', 'c', 'v', 'b', 'n', 'm', ',', '.', '/'}};

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 실수로 소문자 입력해버림ㅠㅠ
		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key[i].length; j++) {
				if (Character.isAlphabetic(key[i][j]))
					key[i][j] = Character.toUpperCase(key[i][j]);
			}
		}

		String s;
		while (true) {
			try {
				s = br.readLine();
				if (s.isBlank())
					break;
				solve(s);
				sb.append("\n");
			} catch (Exception e) {
				System.out.println(sb);
				return;
			}
		}
		System.out.println(sb);

	}

	static void solve(String s) {
		for (int k = 0; k < s.length(); k++) {
			char c = s.charAt(k);

			if (c == ' ' || c == '\n') {
				sb.append(c);
				continue;
			}

			loop:
			for (char[] chars : key) {
				for (int j = 0; j < chars.length; j++) {
					if (chars[j] == c) {
						sb.append(chars[j - 1]);
						break loop;
					}
				}
			}
		}
	}
}