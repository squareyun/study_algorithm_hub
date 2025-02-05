class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int acc = 0;
        int cur = health;
        int idx = 0;
        for (int i = 1; i <= attacks[attacks.length-1][0]; i++){
            if (i != attacks[idx][0]){
                cur += bandage[1];
                acc++;
                if (acc == bandage[0]){
                    cur += bandage[2];
                    acc = 0;
                }
                if (cur > health) cur = health;
            } else {
                acc = 0;
                cur -= attacks[idx][1];
                idx++;
                if (cur <= 0) return -1;
            }
        }
        
        return cur;
    }
}