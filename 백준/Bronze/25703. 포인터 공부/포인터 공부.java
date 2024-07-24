import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sb.append("int a;").append("\n");
		String cur, prev = "a";
		for (int i = 1; i <= N; i++) {
			cur = "ptr" + (i != 1 ? i : "");
			sb.append("int ");
			sb.append("*".repeat(i));
			sb.append(cur);
			sb.append(" = &");
			sb.append(prev);
			sb.append(";");
			prev = cur;
			sb.append("\n");
		}
		System.out.println(sb);
	}
}