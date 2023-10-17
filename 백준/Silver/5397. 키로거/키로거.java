import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String L = br.readLine();
            List<Character> stack = new LinkedList<>();
            int idx = 0;

            for (int i = 0; i < L.length(); i++) {
                char c = L.charAt(i);

                switch (c) {
                    case '<':
                        if (idx > 0) idx--;
                        break;
                    case '>':
                        if (idx < stack.size()) idx++;
                        break;
                    case '-':
                        if (idx > 0 && !stack.isEmpty())
                            stack.remove(--idx);
                        break;
                    default:
                        stack.add(idx++, c);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}