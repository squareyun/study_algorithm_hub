import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[53];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[Integer.parseInt(st.nextToken())]++;
		}
		String s = br.readLine();
		for (char c : s.toCharArray()) {
			if (c == ' ') {
				arr[0]--;
			} else if (c - 'Z' > 0) {
				arr[c - 'a' + 27]--;
			} else {
				arr[c - 'A' + 1]--;
			}
		}

		boolean flag = true;
		for (int i = 0; i < 53; i++) {
			if (arr[i] != 0) {
				flag = false;
				break;
			}
		}
		System.out.println(flag ? "y" : "n");
	}

}