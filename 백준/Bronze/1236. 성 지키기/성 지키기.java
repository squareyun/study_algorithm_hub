import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[][] map = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = (s.charAt(j) != '.');
			}
		}
		//입력끝

		int row = 0, col = 0;

		for (int i = 0; i < N; i++) {
			boolean flag = true;
			for (int j = 0; j < M; j++) {
				if (map[i][j]) {
					flag = false;
					break;
				}
			}
			if (flag)
				row++;
		}

		for (int i = 0; i < M; i++) {
			boolean flag = true;
			for (int j = 0; j < N; j++) {
				if (map[j][i]) {
					flag = false;
					break;
				}
			}
			if (flag)
				col++;
		}

		System.out.println(Math.max(row, col));
	}

}