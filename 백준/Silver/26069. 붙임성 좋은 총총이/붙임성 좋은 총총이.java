import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static HashSet<String> hs;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		hs = new HashSet<>();

		hs.add("ChongChong");
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			String B = st.nextToken();
			if (hs.contains(A))
				hs.add(B);
			if (hs.contains(B))
				hs.add(A);
		}
		System.out.println(hs.size());
	}
}