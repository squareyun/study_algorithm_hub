import java.util.*;
import java.io.*;

public class Main {

	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M;
		for (int i = 0; i < N; i++) {
			M = Integer.parseInt(st.nextToken());
			if (M == 300) sb.append(1);
			else if (M >= 275) sb.append(2);
			else if (M >= 250) sb.append(3);
			else sb.append(4);
			sb.append(' ');
		}
		System.out.println(sb);
	}
}