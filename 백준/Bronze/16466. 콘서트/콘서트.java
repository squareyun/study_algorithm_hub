import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<Integer> hs = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			hs.add(Integer.parseInt(st.nextToken()));
		}
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			if (!hs.contains(i)) {
				System.out.println(i);
				return;
			}
		}
	}

}