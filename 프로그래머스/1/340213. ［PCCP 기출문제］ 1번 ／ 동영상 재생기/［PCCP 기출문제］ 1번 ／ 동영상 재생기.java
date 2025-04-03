class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int len = convert(video_len);
        int cur = convert(pos);
        int start = convert(op_start);
        int end = convert(op_end);
        
        if (start <= cur && cur <= end) {
            cur = end;
        }
        
        for (String cmd : commands) {
            if (cmd.equals("prev")) {
                cur = Math.max(0, cur - 10);
            } else if (cmd.equals("next")) {
                cur = Math.min(len, cur + 10);
            }
            
            if (start <= cur && cur <= end) {
                cur = end;
            }
        }
        
        String ans = String.format("%02d:%02d", cur / 60, cur % 60);
        return ans;
    }
    
    static int convert(String time) {
        String[] splits = time.split(":");
        int m = Integer.parseInt(splits[0]);
        int s = Integer.parseInt(splits[1]);
        return m * 60 + s;
    }
}