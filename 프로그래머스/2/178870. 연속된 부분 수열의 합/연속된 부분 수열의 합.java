import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int n = sequence.length;
        
        List<Sub> subList = new ArrayList<>();
        while (true) {
            if (left == n && right == n)
                break;
            
            if (sum == k)
                subList.add(new Sub(left, right, right - left));
            
            if (sum <= k && right < n) {
                right++;
                if (right < n)
                    sum += sequence[right];
            } else {
                if (left < n)
                    sum -= sequence[left];
                left++;
            }
        }
        
        Collections.sort(subList);
        
        return new int[]{subList.get(0).l, subList.get(0).r};
    }
    
    private class Sub implements Comparable<Sub> {
        int l, r, size;
        
        public Sub(int l, int r, int size) {
            this.l=l;
            this.r=r;
            this.size=size;
        }
        
        @Override
        public int compareTo(Sub o) {
            if (o.size == this.size) {
                return Integer.compare(this.l, o.l);
            }
            return Integer.compare(this.size, o.size);
        }
    }
}