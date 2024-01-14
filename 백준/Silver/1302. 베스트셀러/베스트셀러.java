import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (hm.containsKey(s)) {
                hm.replace(s, hm.get(s) + 1);
            } else {
                hm.put(s, 1);
            }
        }

        PriorityQueue<Data> pq = new PriorityQueue<>();
        for (String key : hm.keySet()) {
            pq.add(new Data(key, hm.get(key)));
        }

        System.out.println(pq.poll().title);
    }

    static class Data implements Comparable<Data> {
        String title;
        int n;

        public Data(String title, int n) {
            this.title = title;
            this.n = n;
        }

        @Override
        public int compareTo(Data o) {
            if (this.n == o.n) {
                return this.title.compareTo(o.title);
            } else {
                return Integer.compare(this.n, o.n) * (-1);
            }
        }
    }
}