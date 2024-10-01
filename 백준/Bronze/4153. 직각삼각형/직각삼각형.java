import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[3];
		while (!(s = br.readLine()).equals("0 0 0")) {
			StringTokenizer st = new StringTokenizer(s);
			for (int i = 0; i < 3; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			if (arr[0] * arr[0] + arr[1] * arr[1] == arr[2] * arr[2]) {
				sb.append("right");
			} else {
				sb.append("wrong");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}