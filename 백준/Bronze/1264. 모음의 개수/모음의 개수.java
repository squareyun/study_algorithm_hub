import java.util.*;
import java.io.*;

public class Main {

	static int N, K;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Character> hs = new HashSet<>();
		hs.add('a');
		hs.add('e');
		hs.add('i');
		hs.add('o');
		hs.add('u');
		hs.add('A');
		hs.add('E');
		hs.add('I');
		hs.add('O');
		hs.add('U');


		String s;
		StringBuilder sb = new StringBuilder();
		while (!(s = br.readLine()).equals("#")) {
			int cnt = 0;
			for (int i = 0; i < s.length(); i++) {
				if (hs.contains(s.charAt(i)))
					cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}