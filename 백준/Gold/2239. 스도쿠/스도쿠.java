import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[][] sudoku = new int[9][9];
    static List<int[]> zeros = new ArrayList<>();
    static int zerosSize;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            String input = sc.next();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = input.charAt(j) - '0';
                if (sudoku[i][j] == 0) {
                    zeros.add(new int[]{i, j});
                }
            }
        }
        zerosSize = zeros.size();
        dfs(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(sudoku[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static boolean dfs(int cnt) {
        if (cnt == zerosSize) {
            return true;
        }

        int x = zeros.get(cnt)[0];
        int y = zeros.get(cnt)[1];

        // 현재 위치에 1부터 9까지 모두 넣어본다.
        for (int i = 1; i < 10; i++) {
            sudoku[x][y] = i;
            if (isValid(x, y) && dfs(cnt + 1)) {
                return true;
            }
        }

        sudoku[x][y] = 0; // 넣기 실패했으니 원상 복구
        return false;
    }

    private static boolean isValid(int x, int y) {

        for (int i = 0; i < 9; i++) {
            if (i != x && sudoku[i][y] == sudoku[x][y]) { //  세로 탐색
                return false;
            }
            if (i != y && sudoku[x][i] == sudoku[x][y]) { // 가로 탐색
                return false;
            }
        }

        // 3 * 3 탐색
        for (int i = (x / 3) * 3, k = 0; k < 3; k++, i++) {
            for (int j = (y / 3) * 3, l = 0; l < 3; l++, j++) {
                if (i != x && j != y && sudoku[i][j] == sudoku[x][y]) {
                    return false;
                }
            }
        }

        return true;
    }

}