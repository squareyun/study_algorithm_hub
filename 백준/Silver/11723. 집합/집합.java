import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int S = 0;

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int x = 0;
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());

			String op = st.nextToken();
			if (!op.equals("all") && !op.equals("empty")) {
				x = Integer.parseInt(st.nextToken());
			}

			switch (op) {
				case "add":
					S |= (1 << x);
					break;
				case "remove":
					S &= ~(1 << x);
					break;
				case "check":
					if ((S & (1 << x)) > 0) sb.append("1");
					else sb.append("0");
					sb.append("\n");
					break;
				case "toggle":
					S ^= (1 << x);
					break;
				case "all":
					S = (1 << 21) - 1;
					break;
				case "empty":
					S = 0;
					break;
			}
		}

		System.out.println(sb);
	}
}