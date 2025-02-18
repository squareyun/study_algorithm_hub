import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double x;
		while ((x = Double.parseDouble(br.readLine())) != -1.0) {
			System.out.printf("Objects weighing %.2f on Earth will weigh %.2f on the moon.\n", x, x * 0.167);
		}
	}

}