import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		long V = Long.parseLong(st.nextToken());
		long day = (V - B) / (A - B);
		if ( (V - B) % (A - B) != 0) day++;
		System.out.println(day);
	}

}