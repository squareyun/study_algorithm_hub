import java.util.*;

class Data implements Comparable<Data>{
    int rank;
    int id;

    Data(int rank, int id) {
        this.rank = rank;
        this.id = id;
    }

    @Override
    public int compareTo(Data o) {
        return this.rank - o.rank;
    }        
}

class Solution {
    
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        
        List<Data> list = new ArrayList<>();
        for (int i=0; i<rank.length; i++) {
            list.add(new Data(rank[i], i));
        }
        
        Collections.sort(list);
        
        List<Integer> select = new ArrayList<>();
        for (Data d : list) {
            if (attendance[d.id]) {
                select.add(d.id);
                if (select.size() > 3) break;
            }
        }
        
        answer = 10000 * select.get(0) + 100 * select.get(1) + select.get(2);
        
        return answer;
    }
}