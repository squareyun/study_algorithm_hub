import java.util.*;
import java.io.*;

public class Main {

	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int answer = 0;
		for (int i = 1; i <= 9; i++) {
			int lo = (int) Math.pow(10, i - 1);
			int hi = (int) Math.pow(10, i) - 1;
			if (N >= hi)
				answer += (hi - lo + 1) * i;
			else {
				answer += (N - lo + 1) * i;
				break;
			}
		}
		System.out.println(answer);
	}
}