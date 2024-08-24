import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		StringBuilder sb = new StringBuilder();
		while (!(s = br.readLine()).equals("END")) {
			for (int i = s.length() - 1; i >= 0; i--) {
				sb.append(s.charAt(i));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}