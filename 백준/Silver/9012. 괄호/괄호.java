import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String s = br.readLine();
            ArrayDeque<Character> q = new ArrayDeque<>();
            boolean flag = true;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    q.add(c);
                } else if (c == ')') {
                    if (q.isEmpty()) {
                        flag = false;
                        break;
                    } else if (q.peek() == '(') {
                        q.pollLast();
                    }
                }
            }

            if (flag && !q.isEmpty())
                flag = false;

            sb.append(flag ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }

}