import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long ans = 0;
		long N = Long.parseLong(br.readLine());
		while (N % 5 != 0) {
			N -= 3;
			ans++;
		}

		if (N < 0)
			System.out.println(-1);
		else
			System.out.println(ans + N / 5);
	}

}