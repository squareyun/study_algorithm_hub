import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		StringBuilder sb = new StringBuilder();
		while (!(s = br.readLine()).equals("#")) {
			s = s.toLowerCase();
			HashSet<Character> hs = new HashSet<>();
			for (char c : s.toCharArray()) {
				if (Character.isAlphabetic(c))
					hs.add(c);
			}
			sb.append(hs.size()).append("\n");
		}
		System.out.println(sb);
	}

}