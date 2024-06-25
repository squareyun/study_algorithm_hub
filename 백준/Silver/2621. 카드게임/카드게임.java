import java.io.*;
import java.util.*;

public class Main {

	static Integer[] colors = new Integer[4]; // R, B, Y, G
	static Num[] numbers = new Num[11];
	static int maxNum = -1;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Arrays.fill(colors, 0);

		for (int i = 0; i < 11; i++) {
			numbers[i] = new Num(i, 0);
		}

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			String color = st.nextToken();
			int number = Integer.parseInt(st.nextToken());
			colors[colorConvert(color)]++;
			numbers[number].n = number;
			numbers[number].cnt++;
			maxNum = Math.max(maxNum, number);
		}

		Arrays.sort(colors, Collections.reverseOrder());
		Arrays.sort(numbers);

		System.out.println(getScore());
	}

	static int getScore() {
		// 1.
		if (colors[0] == 5) {
			if (checkStrait())
				return 900 + numbers[0].n;
		}

		// 2.
		if (numbers[0].cnt == 4)
			return 800 + numbers[0].n;

		// 3.
		if (numbers[0].cnt == 3 && numbers[1].cnt == 2)
			return 700 + numbers[0].n * 10 + numbers[1].n;

		// 4.
		if (colors[0] == 5)
			return 600 + numbers[0].n;

		// 5.
		if (checkStrait())
			return 500 + numbers[0].n;

		// 6.
		if (numbers[0].cnt == 3)
			return 400 + numbers[0].n;

		// 7.
		if (numbers[0].cnt == 2 && numbers[1].cnt == 2) {
			return 300 + numbers[0].n * 10 + numbers[1].n;
		}

		// 8.
		if (numbers[0].cnt == 2)
			return 200 + numbers[0].n;

		// 9.
		return 100 + numbers[0].n;
	}

	static boolean checkStrait() {
		boolean flag = true;
		for (int i = 0; i < 4; i++) {
			if (numbers[i].cnt != 1 || (numbers[i].n != numbers[i + 1].n + 1)) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	static class Num implements Comparable<Num> {
		int n = 0;
		int cnt = 0;

		public Num(int n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Num o) {
			if (this.cnt == o.cnt) {
				return Integer.compare(o.n, this.n);
			} else {
				return Integer.compare(o.cnt, this.cnt);
			}
		}
	}

	static Integer colorConvert(String s) {
		switch (s) {
			case "R":
				return 0;
			case "B":
				return 1;
			case "Y":
				return 2;
			case "G":
				return 3;
		}
		return -1;
	}
}