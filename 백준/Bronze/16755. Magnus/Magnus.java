import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char[] honi = {'H', 'O', 'N', 'I'};

		int idx = 0;
		int answer = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == honi[idx]) {
				idx++;
				if (idx == 4) {
					idx = 0;
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}