import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, total;
    static Queue<Edge> pq = new PriorityQueue<>();
    static int[] p;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        p = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i;
        }

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < N; j++) {
                char c = s.charAt(j);
                if ('a' <= c && c <= 'z') {
                    pq.add(new Edge(i, j, c - 'a' + 1));
                    total += c - 'a' + 1;
                } else if ('A' <= c && c <= 'Z') {
                    pq.add(new Edge(i, j, c - 'A' + 1 + 26));
                    total += c - 'A' + 1 + 26;
                }
            }
        }

//        int count = 0;
//        int sumWeight = 0;
//        for (Edge edge : pq) {
//            if (union(edge.from, edge.to)) {
//                sumWeight += edge.weight;
//                if(++count == N-1) break;
//            }
//        }

        int pqSZ = pq.size();
        int count = 1;
        int sumWeight = 0;
        for (int i = 0; i < pqSZ; i++) {
            Edge e = pq.poll();
            int rx = find(e.from);
            int ry = find(e.to);

            if (rx != ry) {
                count++;
                sumWeight += e.weight;
                union(e.from, e.to);
            }
        }

        if (count != N) {
            System.out.println(-1);
        } else {
            System.out.println(total - sumWeight);
        }
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        p[rootB] = rootA;
    }

    static int find(int a) {
        if (p[a] == a) {
            return a;
        }

        return p[a] = find(p[a]);
    }

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}