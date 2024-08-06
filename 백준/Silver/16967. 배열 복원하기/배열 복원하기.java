import java.util.*;
import java.io.*;

public class Main {

	static int H, W, X, Y;
	static int[][] B;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		B = new int[H + X][W + Y];
		for (int i = 0; i < H + X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W + Y; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = X; i < H + X; i++) {
			for (int j = Y; j < W + Y; j++) {
				B[i][j] -= B[i - X][j - Y];
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				sb.append(B[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}