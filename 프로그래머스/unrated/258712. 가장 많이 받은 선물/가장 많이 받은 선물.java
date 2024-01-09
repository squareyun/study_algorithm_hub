import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        int N = friends.length;
        int[][] map = new int[N][N];
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (int i=0; i<N; i++) {
            hm.put(friends[i], i);
        }
        
        // 주고받은 선물 계산
        for (String gift : gifts) {
            StringTokenizer st = new StringTokenizer(gift);
            map[hm.get(st.nextToken())][hm.get(st.nextToken())]++;
        }
        
        // 선물지수 계산
        int[] score = new int[N];
        for (int i=0; i<N; i++) {
            int give = 0;
            for (int j=0; j<N; j++) {
                give += map[i][j];
            }
            
            int taken = 0;
            for (int j=0; j<N; j++) {
                taken += map[j][i];
            }
            
            score[i] = give - taken;
        }
        
        int[] answer = new int[N];
        
        for (int i=0; i<N; i++) {
            for (int j=i+1; j<N; j++) {                
                int a = map[i][j]; // A가 B에게 준 선물
                int b = map[j][i]; // B가 A에게 준 선물
                
                if (a > b) answer[i]++;
                else if (b > a) answer[j]++;
                else {
                    int sa = score[i];
                    int sb = score[j];
                    
                    if (sa > sb) answer[i]++;
                    else if (sb > sa) answer[j]++;
                }
            }
        }
        
        return Arrays.stream(answer).max().getAsInt();
    }
}