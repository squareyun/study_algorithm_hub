import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		if (N == 0) {
			System.out.println(0);
			return;
		}

		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();

		queue.add(N);
		visited.add(N);

		int steps = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int num = queue.poll();

				if (num == 0) {
					System.out.println(steps);
					return;
				}

				// 1을 뺀다
				if (!visited.contains(num - 1)) {
					queue.add(num - 1);
					visited.add(num - 1);
				}

				// 1을 지운다
				String strNum = String.valueOf(num);
				for (int j = 0; j < strNum.length(); j++) {
					if (strNum.charAt(j) == '1') {
						String newNumStr = strNum.substring(0, j) + strNum.substring(j + 1);
						if (newNumStr.isEmpty()) {
							newNumStr = "0";
						}
						int newNum = Integer.parseInt(newNumStr);
						if (!visited.contains(newNum)) {
							queue.add(newNum);
							visited.add(newNum);
						}
					}
				}
			}
			steps++;
		}
	}
}