import java.util.*;

class Solution {
    
    static boolean[] v;
    static HashSet<String> set;
    
    public int solution(String[] user_id, String[] banned_id) {
        v = new boolean[user_id.length];
        set = new HashSet<>();
        
        for (int i=0; i<banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace("*", "."); // 정규식 표현에서 . 는 어떤 문자 하나를 의미
        }
        
        dfs(0, "", user_id, banned_id);
        
        return set.size();
    }
    
    static void dfs(int cnt, String banString, String[] user_id, String[] banned_id) {
        if (cnt == banned_id.length) {
            String[] split = banString.split(" ");
            Arrays.sort(split);
            
            StringBuilder sb = new StringBuilder();
            for (String s : split) {
                sb.append(s);
            }
            set.add(sb.toString());
            return;
        }
        
        for (int i=0; i<user_id.length; i++) {
            if (v[i]) continue;
            
            if (user_id[i].matches(banned_id[cnt])) {
                v[i] = true;
                dfs(cnt + 1, user_id[i] + " " + banString, user_id, banned_id);
                v[i] = false;
            }
        }
    }
}