import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		System.out.println(solve(s));
	}

	private static int solve(String s) {
		switch (s) {
			case "(1)":
				return 0;
			case "()1":
			case "1()":
			case ")(1":
			case "1)(":
				return 1;
			case ")1(":
				return 2;
		}
		return -1;
	}
	
}