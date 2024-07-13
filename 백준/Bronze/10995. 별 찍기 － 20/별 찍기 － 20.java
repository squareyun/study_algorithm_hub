import java.util.*;
import java.io.*;

public class Main {

	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append((i % 2 == 0) ? " *" : "* ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}