import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		TreeMap<Integer, Integer> tm = null;
		int k, num, t;
		String cmd;
		for (int tc = 1; tc <= T; tc++) {
			k = sc.nextInt();
			tm = new TreeMap<>(); // TreeMap 자료구조 사용
			for (int i = 0; i < k; i++) {
				cmd = sc.next();
				num = sc.nextInt();

				if (cmd.equals("I")) {
					tm.put(num, tm.getOrDefault(num, 0) + 1);
				} else if (cmd.equals("D")) {

					if (tm.isEmpty())
						continue; // 비어있는 경우 무시

					if (num == 1) {
						t = tm.lastKey();
						tm.put(t, tm.get(t) - 1);
						if (tm.get(t) == 0) {
							tm.remove(t);
						}
					} else if (num == -1) {
						t = tm.firstKey();
						tm.put(t, tm.get(t) - 1);
						if (tm.get(t) == 0) {
							tm.remove(t);
						}
					}
				}
			}

			if (tm.isEmpty())
				System.out.println("EMPTY");
			else
				System.out.println(tm.lastKey() + " " + tm.firstKey());
		}
	}

}