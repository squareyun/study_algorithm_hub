import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(br.readLine());
            PriorityQueue<Data> pq = new PriorityQueue<>();
            for (int j = 0; j < p; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                pq.offer(new Data(Integer.parseInt(st.nextToken()), st.nextToken()));
            }
            System.out.println(pq.poll().name);
        }
    }

    static class Data implements Comparable<Data> {
        int c;
        String name;

        public Data(int c, String name) {
            this.c = c;
            this.name = name;
        }

        @Override
        public int compareTo(Data o) {
            return -Integer.compare(this.c, o.c);
        }
    }

}