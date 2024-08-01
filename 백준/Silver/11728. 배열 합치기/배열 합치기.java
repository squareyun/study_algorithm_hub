import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[] A, B;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N];
		B = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		int len = N + M;
		int[] ret = new int[len];
		int idx = 0, aPointer = 0, bPointer = 0;
		while (aPointer < N && bPointer < M) {
			if (A[aPointer] < B[bPointer])
				ret[idx++] = A[aPointer++];
			else
				ret[idx++] = B[bPointer++];
		}

		while (aPointer < N)
			ret[idx++] = A[aPointer++];
		while (bPointer < M)
			ret[idx++] = B[bPointer++];

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			sb.append(ret[i]);
			if (i < len - 1) sb.append(" ");
		}
		System.out.println(sb);
	}

}