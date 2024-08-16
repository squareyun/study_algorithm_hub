import java.util.*;
import java.io.*;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s;
		while ((s = br.readLine()) != null) {
			sb.append(s);
		}

		String[] splits = sb.toString().split(",");
		long ans = 0;
		for (String split : splits) {
			ans += Long.parseLong(split);
		}
		System.out.println(ans);
	}

}