import java.util.*;
import java.io.*;

public class Main {

	static double X, Y;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		// System.out.println(Math.floor(Y * 100 / X));
		int target = (int) Math.floor((Y * 100 / X)) + 1;
		// System.out.println(target);
		if (target >= 100) {
			System.out.println(-1);
			return;
		}
		int answer = (int) Math.ceil((target * X - 100 * Y) / (100 - target));
		System.out.println(answer);
	}
}