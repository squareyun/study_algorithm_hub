import java.io.*;
import java.util.*;

public class Main {

    static int n, q, m;
    static ArrayList<Integer> list = new ArrayList<>();
    static HashMap<Integer, Integer> hm = new HashMap<>();
    static HashMap<Integer, Long> memo = new HashMap<>();
    
    static long answer;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            int x = Integer.parseInt(st.nextToken());
            list.add(x);
        }
        Collections.sort(list);
        int listMinValue = list.get(0);
        int listMaxValue = list.get(list.size()-1);
        for (int i=0; i<list.size(); i++) {
            hm.put(list.get(i), i);
        }

        StringBuilder sb = new StringBuilder();
        while (q-->0) {
            m = Integer.parseInt(br.readLine());

            if (m == listMinValue) sb.append(0);
            else if(m == listMaxValue) sb.append(0);
            else if(!hm.containsKey(m)) sb.append(0);
            else if(memo.containsKey(m)) sb.append(memo.get(m));
            else {
                int idx = hm.get(m);
                answer = idx * (n - idx - 1);
                memo.put(m, answer);
                sb.append(answer);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
