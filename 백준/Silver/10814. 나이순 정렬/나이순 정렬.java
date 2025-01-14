import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Data> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            pq.offer(new Data(i, age, name));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Data cur = pq.poll();
            sb.append(cur.age).append(" ").append(cur.name).append("\n");
        }
        System.out.println(sb);
    }

    static class Data implements Comparable<Data> {
        int id;
        int age;
        String name;

        public Data(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Data o) {
            if (this.age == o.age) {
                return Integer.compare(this.id, o.id);
            }
            return Integer.compare(this.age, o.age);
        }
    }
}