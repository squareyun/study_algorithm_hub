import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int x, t;
        while (Q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            switch (op) {
                case 1:
                    x = Integer.parseInt(st.nextToken());
                    if (x == 1)
                        Collections.sort(list);
                    else if (x == 2)
                        list.sort(Collections.reverseOrder());
                    break;
                case 2:
                    x = Integer.parseInt(st.nextToken());
                    t = Integer.parseInt(st.nextToken());
                    list.add(x, t);
            }
        }
        System.out.println(list.size());
        for (int a : list) {
            System.out.print(a + " ");
        }
    }
}
