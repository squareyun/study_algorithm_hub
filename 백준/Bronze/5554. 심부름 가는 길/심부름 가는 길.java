import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		a += Integer.parseInt(br.readLine());
		a += Integer.parseInt(br.readLine());
		a += Integer.parseInt(br.readLine());
		System.out.println(a / 60);
		System.out.println(a % 60);
	}
}