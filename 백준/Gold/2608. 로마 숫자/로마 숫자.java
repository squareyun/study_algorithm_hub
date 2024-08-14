import java.util.*;
import java.io.*;

public class Main {

	static String numStr1, numStr2, ansStr;
	static int num1, num2, ans;
	static HashMap<String, Integer> hm;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		numStr1 = br.readLine();
		numStr2 = br.readLine();
		initHashMap();
		num1 = roman2int(numStr1);
		num2 = roman2int(numStr2);
		// System.out.println(num1);
		// System.out.println(num2);

		ans = num1 + num2;
		ansStr = int2roman(ans);

		System.out.println(ans);
		System.out.println(ansStr);
	}
	private static int roman2int(String str) {
		int ret = 0;

		for (int i = 0; i < str.length(); i++) {
			String one = str.substring(i, i + 1);

			if (i < str.length() - 1) {
				String two = str.substring(i, i + 2);
				if (hm.containsKey(two)) {
					ret += hm.get(two);
					i++;
					continue;
				}
			}

			ret += hm.get(one);
		}

		return ret;
	}

	private static String int2roman(int num) {
		List<Map.Entry<String, Integer>> list = new ArrayList<>(hm.entrySet());
		list.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));

		StringBuilder sb = new StringBuilder();
		while (num != 0) {
			int quo = 0;
			for (Map.Entry<String, Integer> entry : list) {
				quo = num / entry.getValue();
				if (quo != 0) {
					for (int i = 0; i < quo; i++) {
						sb.append(entry.getKey());
					}
					num = num % entry.getValue();
					break;
				}
			}
		}

		return sb.toString();
	}


	private static void initHashMap() {
		hm = new HashMap<>();
		hm.put("I", 1);
		hm.put("V", 5);
		hm.put("X", 10);
		hm.put("L", 50);
		hm.put("C", 100);
		hm.put("D", 500);
		hm.put("M", 1000);
		hm.put("IV", 4);
		hm.put("IX", 9);
		hm.put("XL", 40);
		hm.put("XC", 90);
		hm.put("CD", 400);
		hm.put("CM", 900);
	}
}