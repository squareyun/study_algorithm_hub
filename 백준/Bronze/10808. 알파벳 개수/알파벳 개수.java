import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[26];
		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);
	}
}