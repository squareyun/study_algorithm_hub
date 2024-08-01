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
		A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int len = N + M;
		int[] ret = new int[len];
		int idx = 0, aPointer = 0, bPointer = 0;
		while (idx < len && aPointer < N && bPointer < M) {
			if (A[aPointer] < B[bPointer])
				ret[idx++] = A[aPointer++];
			else
				ret[idx++] = B[bPointer++];
		}

		if (idx != len) {
			if (aPointer == N) {
				while (bPointer < M)
					ret[idx++] = B[bPointer++];
			} else if (bPointer == M) {
				while (aPointer < N) {
					ret[idx++] = A[aPointer++];
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i : ret)
			sb.append(i).append(" ");
		System.out.println(sb);
	}

}