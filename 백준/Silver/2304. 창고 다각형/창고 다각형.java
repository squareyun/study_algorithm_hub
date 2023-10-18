import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] pos = new int[1001];

        int L, H;
        int start = 1001;
        int end = 0;
        for (int i = 0; i < N; i++) {
            L = sc.nextInt();
            H = sc.nextInt();
            pos[L] = H;
            start = Math.min(start, L);
            end = Math.max(end, L);
        }

        Stack<Integer> stack = new Stack<>();

        // 왼쪽에서 오른쪽 계산
        int cur = pos[start];
        for (int i = start + 1; i <= end; i++) {
            if (pos[i] < cur) {
                stack.push(i); // 채워줄 공간 기록
            } else {
                while (!stack.isEmpty()) {
                    pos[stack.pop()] = cur;
                }
                cur = pos[i];
            }
        }
        stack.clear();

        // 왼쪽에서 오른쪽 계산
        cur = pos[end];
        for (int i = end - 1; i >= start; i--) {
            if (pos[i] < cur) {
                stack.push(i); // 채워줄 공간 기록
            } else {
                while (!stack.isEmpty()) {
                    pos[stack.pop()] = cur;
                }
                cur = pos[i];
            }
        }

        int ans = 0;
        for (int i = start; i <= end; i++) {
            ans += pos[i];
        }
        System.out.println(ans);

    }
}