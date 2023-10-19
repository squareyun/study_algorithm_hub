import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            sb.append(q.poll()).append(' ');
            q.offer(q.poll());
        }

        sb.append(q.poll());
        System.out.println(sb);
    }
}