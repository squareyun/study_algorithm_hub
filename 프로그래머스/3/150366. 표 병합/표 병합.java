import java.util.*;

class Solution {
    
    static String[][] cell = new String[51][51];
    static int[][] p = new int[51][51];
    static int r, c, r1, c1, r2, c2, root;
    
    public String[] solution(String[] commands) {
        ArrayList<String> answer = new ArrayList<>();
        
        makeSet();
        
        for (String command : commands) {
            String[] cmd = command.split(" ");
            
            switch(cmd[0]) {
                case "UPDATE":
                    try {
                        r = Integer.parseInt(cmd[1]);
                        c = Integer.parseInt(cmd[2]);
                        
                        root = find(r, c);
                        cell[root/100][root%100] = cmd[3];
                        break;
                    } catch (Exception e) {
                        for (int i=1; i<51; i++) {
                            for (int j=1; j<51; j++) {
                                if (cell[i][j] != null && cell[i][j].equals(cmd[1])) cell[i][j] = cmd[2];
                            }
                        }
                    }
                    break;
                    
                case "MERGE":
                    r1 = Integer.parseInt(cmd[1]);
                    c1 = Integer.parseInt(cmd[2]);
                    r2 = Integer.parseInt(cmd[3]);
                    c2 = Integer.parseInt(cmd[4]);
                    
                    int root1 = find(r1, c1);
                    int root2 = find(r2, c2);
                    
                    // 같은 셀일 경우 무시
                    if (root1 == root2) break;
                    // 값을 가진 쪽으로 병합
                    String s = cell[root1/100][root1%100] != null ? cell[root1/100][root1%100] : cell[root2/100][root2%100];
                    
                    cell[root1/100][root1%100] = null;
                    cell[root2/100][root2%100] = null;
                    union(r1, c1, r2, c2);
                    cell[root1/100][root1%100] = s;
                    break;
                    
                case "UNMERGE":
                    r = Integer.parseInt(cmd[1]);
                    c = Integer.parseInt(cmd[2]);
                    
                    root = find(r, c);
                    String prev = cell[root/100][root%100];
                    
                    cell[root/100][root%100] = null;
                    cell[r][c] = prev;
                    
                    List<Integer> deleteList = new ArrayList<>();
                    for (int i=1; i<51; i++) {
                        for (int j=1; j<51; j++) {
                            if (find(i, j) == root) {
                                deleteList.add(i * 100 + j);
                            }
                        }
                    }
                    
                    for (Integer d : deleteList) {
                        p[d / 100][d % 100] = d;
                    }
                    break;
                    
                case "PRINT":
                    r = Integer.parseInt(cmd[1]);
                    c = Integer.parseInt(cmd[2]);
                    root = find(r, c);
                    String ans = cell[root/100][root%100];
                    if (ans != null) {
                        answer.add(ans);
                    } else {
                        answer.add("EMPTY");
                    }
                    break;
            }
        }
        
        return answer.toArray(new String[0]);
    }
    
    static void union(int r1, int c1, int r2, int c2) {
        int rootA = find(r1, c1);
        int rootB = find(r2, c2);
        
        p[rootB/100][rootB%100] = rootA;
    }
    
    static int find(int r, int c) {
        if (p[r][c] == r * 100 + c) {
            return r * 100 + c;
        }
        
        return p[r][c] = find(p[r][c] / 100, p[r][c] % 100);
    }
    
    static void makeSet() {
        for (int i=1; i<51; i++) {
            for (int j=1; j<51; j++) {
                p[i][j] = i * 100 + j;
            }
        }
    }
}