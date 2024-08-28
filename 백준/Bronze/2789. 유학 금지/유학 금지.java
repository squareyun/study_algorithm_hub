import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String cambridge = "CAMBRIDGE";
		HashSet<Character> hs = new HashSet<>();
		for (int i = 0; i < cambridge.length(); i++) {
			hs.add(cambridge.charAt(i));
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if (!hs.contains(input.charAt(i))) {
				sb.append(input.charAt(i));
			}
		}
		System.out.println(sb);
	}

}