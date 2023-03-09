import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[x][y] = arr[y][x] = 1;
        }

        dfs(start);
        System.out.println();

        visited = new boolean[n + 1];
        bfs(start);
        sc.close();
    }

    static void dfs(int k) {
        if (visited[k]) {
            return;
        }

        visited[k] = true;
        System.out.print(k + " ");

        for (int i = 1; i <= n; i++) {
            if (arr[k][i] == 1) {
                dfs(i);
            }
        }
    }

    static void bfs(int k) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(k);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            visited[temp] = true;
            System.out.print(temp + " ");
            for (int i = 1; i <= n; i++) {
                if (arr[temp][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
