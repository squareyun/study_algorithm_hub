import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Data> pq = new PriorityQueue<>();
        HashSet<String> hs = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (!hs.contains(s)) pq.offer(new Data(s.length(), s));
            hs.add(s);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll().str).append("\n");
        }
        System.out.println(sb);
    }

    static class Data implements Comparable<Data> {
        int len;
        String str;

        public Data(int len, String str) {
            this.len = len;
            this.str = str;
        }


        @Override
        public int compareTo(Data o) {
            if (this.len == o.len) {
                return this.str.compareTo(o.str);
            } else {
                return Integer.compare(this.len, o.len);
            }
        }
    }
}