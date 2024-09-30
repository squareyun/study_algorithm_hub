import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] fruits = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}

		HashMap<Integer, Integer> hm = new HashMap<>();
		int ans = 0;
		int left = 0;
		for (int right = 0; right < N; right++) {
			hm.put(fruits[right], hm.getOrDefault(fruits[right], 0) + 1);

			while (hm.size() > 2) {
				hm.put(fruits[left], hm.get(fruits[left]) - 1);

				if (hm.get(fruits[left]) == 0)
					hm.remove(fruits[left]);

				left++;
			}
			ans = Math.max(ans, right - left + 1);
		}
		System.out.println(ans);
	}
}