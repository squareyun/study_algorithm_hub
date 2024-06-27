import java.util.*;
import java.io.*;

public class Main {

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String binaryN = Integer.toBinaryString(N);
		String binaryNComplement = Integer.toBinaryString(-N);

		StringBuilder zero = new StringBuilder();
		zero.append("0".repeat(32 - binaryN.length()));
		binaryN = zero.toString() + binaryN;

		int answer = 0;
		for (int i = 0; i < 32; i++) {
			if (binaryN.charAt(i) == binaryNComplement.charAt(i)) {
				answer++;
			}
		}
		answer = 32 - answer;
		System.out.println(answer);
	}
}