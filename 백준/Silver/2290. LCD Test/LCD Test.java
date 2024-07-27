import java.util.*;
import java.io.*;

public class Main {

	static int s;
	static String[] inputN;
	static int width, height;

	static StringBuilder[][] printer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		inputN = st.nextToken().split("");

		width = s + 2;
		height = 2 * s + 3;
		printer = new StringBuilder[10][height];
		for (int n = 0; n < 10; n++) {
			for (int h = 0; h < height; h++) {
				printer[n][h] = new StringBuilder();
			}
		}

		for (int h = 0; h < height; h++) {
			for (int n = 0; n < 10; n++) {
				make(h, n);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int h = 0; h < height; h++) {
			for (String n : inputN) {
				sb.append(printer[Integer.parseInt(n)][h]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void make(int h, int n) {

		if (h == 0 || h == height - 1) {
			printer[n][h].append(" ");

			for (int i = 1; i < width - 1; i++) {
				if (n == 1 || n == 4)
					printer[n][h].append(" ");
				else if (n == 7 && h == height - 1)
					printer[n][h].append(" ");
				else
					printer[n][h].append("-");
			}

			printer[n][h].append(" ");

		} else if (1 <= h && h < height / 2) {
			if (n == 1 || n == 2 || n == 3 || n == 7)
				printer[n][h].append(" ");
			else
				printer[n][h].append("|");

			for (int i = 1; i < width - 1; i++) {
				printer[n][h].append(" ");
			}

			if (n == 5 || n == 6)
				printer[n][h].append(" ");
			else
				printer[n][h].append("|");

		} else if (h == height / 2) {
			printer[n][h].append(" ");

			for (int i = 1; i < width - 1; i++) {
				if (n == 1 || n == 7 || n == 0)
					printer[n][h].append(" ");
				else
					printer[n][h].append("-");
			}

			printer[n][h].append(" ");

		} else if (height / 2 < h && h < height - 1) {
			if (n == 1 || n == 3 || n == 4 || n == 5 || n == 7 || n == 9)
				printer[n][h].append(" ");
			else
				printer[n][h].append("|");

			for (int i = 1; i < width - 1; i++) {
				printer[n][h].append(" ");
			}

			if (n == 2)
				printer[n][h].append(" ");
			else
				printer[n][h].append("|");

		}
	}
}