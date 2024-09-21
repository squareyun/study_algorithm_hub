import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		Double ans = Math.sqrt(3) * Math.pow(L, 2) / 4;
		System.out.println(ans);
	}

}