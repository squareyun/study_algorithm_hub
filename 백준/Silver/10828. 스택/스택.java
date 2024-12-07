import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push" -> {
                    q.offer(Integer.parseInt(st.nextToken()));
                }
                case "pop" -> {
                    if (q.isEmpty())
                        sb.append(-1);
                    else sb.append(q.pollLast());
                    sb.append("\n");
                }
                case "size" -> {
                    sb.append(q.size());
                    sb.append("\n");
                }
                case "empty" -> {
                    sb.append(q.isEmpty() ? 1 : 0);
                    sb.append("\n");
                }
                case "top" -> {
                    if (q.isEmpty())
                        sb.append(-1);
                    else sb.append(q.peekLast());
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
    }

}