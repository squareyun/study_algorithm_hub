import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] score;
    static int[][] scoreSum;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        score = new int[3][N];
        scoreSum = new int[3][N];
        
        StringBuilder sb = new StringBuilder();
        List<Data> list;
        
        for (int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            list = new ArrayList<>();
            
            for (int j=0; j<N; j++) {
                int x = Integer.parseInt(st.nextToken());
                score[i][j] = x;
                list.add(new Data(x, j));
                scoreSum[i][j] = (i == 0) ? x : x + scoreSum[i-1][j];
            }

            Collections.sort(list);

            int rank = 1;
            int[] result = new int[N];
            int tempRank = 1;
            for (int j=0; j<N; j++) {
                Data cur = list.get(j);
                result[cur.idx] = rank;
                if (j != N - 1 && cur.score == list.get(j+1).score) tempRank++;
                else {
                    rank += tempRank;
                    tempRank = 1;
                }
            }

            for (int j=0; j<N; j++) {
                sb.append(result[j]).append(" ");
            }
            sb.append("\n");
        }

        
        list = new ArrayList<>();
        for (int j=0; j<N; j++) {
            list.add(new Data(scoreSum[2][j], j));
        }

        Collections.sort(list);

        int rank = 1;
        int[] result = new int[N];
        int tempRank = 1;
        for (int j=0; j<N; j++) {
            Data cur = list.get(j);
            result[cur.idx] = rank;
            if (j != N - 1 && cur.score == list.get(j+1).score) tempRank++;
            else {
                rank += tempRank;
                tempRank = 1;
            }
        }

        for (int j=0; j<N; j++) {
            sb.append(result[j]).append(" ");
        }
        sb.append("\n");
        

        System.out.println(sb);
    }

    static class Data implements Comparable<Data> {
        int score, idx;
        public Data(int score, int idx) {
            this.score=score;
            this.idx=idx;
        }
        
        @Override
        public int compareTo(Data o) {
            return Integer.compare(o.score, this.score);
        }
    }
}


