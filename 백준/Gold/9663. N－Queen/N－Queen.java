import java.util.Scanner;

public class Main {

	static int N, cnt;
	static int[] arr;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1];
		solve(1);
		System.out.println(cnt);
	}
	
	private static void solve(int r) {
		if (!isAvailable(r-1)) {
			return;
		}
		
		if (r > N) {
			cnt += 1;
			return;
		}
		
		for (int i=1; i<=N; i++) {
			arr[r] = i;
			solve(r + 1);
		}
	}
	
	private static boolean isAvailable(int r) {
		for (int i=1; i<r; i++) {
			if (arr[i] == arr[r] || Math.abs(arr[i]-arr[r]) == r-i)
				return false;
		}
		return true;
	}
}