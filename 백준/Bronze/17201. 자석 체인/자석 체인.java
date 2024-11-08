import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		String sub = s.substring(0, 2);
		boolean flag = true;
		for (int i = 2; i < s.length(); i += 2) {
			if (!s.substring(i, i + 2).equals(sub)) {
				flag = false;
				break;
			}
		}
		System.out.println(flag ? "Yes" : "No");
	}

}