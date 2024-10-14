import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = 2001;
		for (int i = 0; i < 3; i++) {
			a = Math.min(a, Integer.parseInt(br.readLine()));
		}
		int b = 2001;
		for (int i = 0; i < 2; i++) {
			b = Math.min(b, Integer.parseInt(br.readLine()));
		}
		System.out.println(a + b - 50);
	}

}