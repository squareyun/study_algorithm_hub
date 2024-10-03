import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split("/");
		int K = Integer.parseInt(arr[0]);
		int D = Integer.parseInt(arr[1]);
		int A = Integer.parseInt(arr[2]);
		boolean flag = false;
		if (K + A < D || D == 0) {
			flag = false;
		} else {
			flag = true;
		}
		System.out.println(flag ? "gosu" : "hasu");
	}
}