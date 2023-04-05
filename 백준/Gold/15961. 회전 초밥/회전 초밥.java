import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 원형 배열을 위해 배열 늘려서 작업
        int size = N + k - 1;
        int[] arr = new int[size];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N; i < size; i++) {
            arr[i] = arr[i - N];
        }

        int[] eat = new int[d + 1];
        int eatCnt = 0;
        int answer = 0;

        for (int i = 0; i < k; i++) {
            if (eat[arr[i]] == 0) {
                eatCnt++;
            }
            eat[arr[i]]++;
        }

        answer = (eat[c] == 0) ? eatCnt + 1 : eatCnt;

        for (int i = k; i < size; i++) {
            eat[arr[i - k]]--;
            if (eat[arr[i - k]] == 0) {
                eatCnt--;
            }

            if (eat[arr[i]] == 0) {
                eatCnt++;
            }
            eat[arr[i]]++;

            answer = Math.max(answer, (eat[c] == 0) ? eatCnt + 1 : eatCnt);

        }

        System.out.println(answer);
    }

}