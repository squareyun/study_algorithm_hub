import static java.util.Collections.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}

		// step1. 꼭대기를 찾는다. (꼭대기 바로 앞이 교환할 자리)
		int i = N - 1;
		while (i > 0 && arr[i-1] >= arr[i]) --i;

		if (i == 0) {
			System.out.println(-1);
			return;
		}

		// step2. 꼭대기 바로 앞(i-1)자리 보다 한 단계 큰 자리(j) 수 찾기
		int j = N - 1;
		while (arr[i-1] >= arr[j]) --j;

		// step3. 교환
		swap(arr, i-1, j);

		// step4. 꼭대기부터 맨 뒤까지 오름차순 정렬
		int k = N - 1;
		while (i < k) {
			swap(arr, i++, k--);
		}

		StringBuilder sb = new StringBuilder();
		for (int a : arr)
			sb.append(a).append(' ');
		System.out.println(sb);
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}