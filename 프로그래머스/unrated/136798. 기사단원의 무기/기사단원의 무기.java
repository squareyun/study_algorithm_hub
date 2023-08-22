class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i=1; i<=number; i++) {
            int res = numOfPower(i);
            if (res <= limit) answer += res;
            else answer += power;
        }
        return answer;
    }
    
    static int numOfPower(int n) {
        int cnt = 0;
        for (int i=1; i*i <= n; i++) {
            if (i*i == n) cnt++;
            else if (n % i == 0) cnt += 2;
        }
        return cnt;
    }
}