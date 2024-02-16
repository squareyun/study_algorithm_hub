import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Queue<Integer> q = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();

			if (x == 0) {
				if (q.isEmpty())
					sb.append(0);
				else
					sb.append(q.poll());
				sb.append("\n");
			} else {
				q.offer(x);
			}
		}

		System.out.println(sb);
	}
}