import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortedA = A.clone();
        Arrays.sort(sortedA);

        Map<Integer, Queue<Integer>> posMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int val = sortedA[i];
            posMap.putIfAbsent(val, new LinkedList<>());
            posMap.get(val).add(i);
        }

        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = posMap.get(A[i]).poll();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(P[i]).append(" ");
        }
        System.out.println(sb);
    }

}