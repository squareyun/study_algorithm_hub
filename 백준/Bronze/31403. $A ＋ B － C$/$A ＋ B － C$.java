import java.util.*;
import java.io.*;

public class Main {

	static int a, b, c;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = Integer.parseInt(br.readLine());
		b = Integer.parseInt(br.readLine());
		c = Integer.parseInt(br.readLine());
		System.out.println(a + b - c);

		String abStr = String.valueOf(a).concat(String.valueOf(b));
		int ab = Integer.parseInt(abStr);
		System.out.println(ab - c);
	}
}