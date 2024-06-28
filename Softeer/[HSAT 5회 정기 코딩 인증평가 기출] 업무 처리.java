import java.io.*;
import java.util.*;

public class Main {

    static int H, K, R;
    // static Queue<Integer> taskL, taskR;
    static Node[] tree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        tree = new Node[(int)Math.pow(2, H+1) - 1];
        for (int i=0; i<tree.length; i++) {
            tree[i] = new Node();
        }
        
        int maldan = (int)Math.pow(2, H) - 1;
        for (int t=maldan; t<tree.length; t++) {
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<K; i++) {
                tree[t].left.add(Integer.parseInt(st.nextToken()));
            }
            // print(t, tree[t]);
        }
        

        int answer = 0;
        for (int r=1; r<=R; r++) {
            // print(1, tree[1]);
            // print(2, tree[2]);
            
            // 부사장
            Node cur = tree[0];
            if (r % 2 == 1 && cur.left.size() != 0) {
                answer += cur.left.poll();
            } else if (r % 2 == 0 && cur.right.size() != 0) {
                answer += cur.right.poll();
            }

            // 그 외 직원 업무 올리기
            for (int i=1; i<maldan; i++) {
                cur = tree[i];
                boolean isLeft = (i % 2 == 1);
                int p = isLeft ? i / 2 : i / 2 - 1;
                if (r % 2 == 1 && cur.left.size() != 0) {
                    if (isLeft) tree[p].left.add(cur.left.poll());
                    else tree[p].right.add(cur.left.poll());
                } else if (r % 2 == 0 && cur.right.size() != 0) {
                    if (isLeft) tree[p].left.add(cur.right.poll());
                    else tree[p].right.add(cur.right.poll());
                }
            }
            
            // 말단 노드 업무 올리기
            for (int i=maldan; i<tree.length; i++) {
                cur = tree[i];
                boolean isLeft = (i % 2 == 1);
                int p = isLeft ? i / 2 : i / 2 - 1;
                if (cur.left.size() != 0) {
                    if (isLeft) tree[p].left.add(cur.left.poll());
                    else tree[p].right.add(cur.left.poll());
                }
            }
            // print(1, tree[1]);
            // print(2, tree[2]);
        }
        System.out.println(answer);
    }

    static class Node {
        Queue<Integer> left, right;
        public Node() {
            left = new ArrayDeque<>();
            right = new ArrayDeque<>();
        }
    }

    static void print(int idx, Node node) {
        System.out.println("==== " + idx + "child");
        System.out.println("= left =");
        for (int i : node.left) {
            System.out.println(i + " ");
        }
        System.out.println();
        System.out.println("= right =");
        for (int i : node.right) {
            System.out.println(i + " ");
        }
    }
}

