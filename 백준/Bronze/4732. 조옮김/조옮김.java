import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] scale = {"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"};
		String s;
		int move = 0;
		StringBuilder sb = new StringBuilder();
		while (!(s = br.readLine()).equals("***")) {
			move = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(s);

			int idx = 0;
			while (st.countTokens() > 0) {
				idx = switch (st.nextToken()) {
					case "A" -> 0;
					case "A#", "Bb" -> 1;
					case "B", "Cb" -> 2;
					case "B#", "C" -> 3;
					case "C#", "Db" -> 4;
					case "D" -> 5;
					case "D#", "Eb" -> 6;
					case "E", "Fb" -> 7;
					case "E#", "F" -> 8;
					case "F#", "Gb" -> 9;
					case "G" -> 10;
					case "G#", "Ab" -> 11;
					default -> idx;
				};
				if (idx + move < 0) idx += 12;
				sb.append(scale[(idx + move) % 12]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}