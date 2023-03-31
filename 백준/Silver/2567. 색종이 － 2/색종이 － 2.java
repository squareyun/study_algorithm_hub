import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[][] map = new boolean[102][102];
		
		// 지도를 그린다.
		for (int t=0; t<N; t++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			
			for (int i=r; i<r+10; i++) {
				for (int j=c; j<c+10; j++) {
					map[i][j] |= true; // 중복 제거
				}
			}
		}
		
		// 변을 따라 순회하며 false인 경우 둘레를 계산한다.
		int ans = 0;
		for (int i=0; i<101; i++) {
			for (int j=0; j<101; j++) {
				if (map[i][j]) continue;
				if (map[i+1][j]) ans++; // 아래변
				if (map[i][j+1]) ans++; // 우변
				if (i > 0 && map[i-1][j]) ans++; // 좌변
				if (j > 0 && map[i][j-1]) ans++; // 윗변
					
			}
		}
		
		System.out.println(ans);
	}

}