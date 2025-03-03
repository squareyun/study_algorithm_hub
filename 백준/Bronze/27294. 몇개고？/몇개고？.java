import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        boolean isLunch = T >= 12 && T <= 16;
        boolean isAlcohol = S == 1;
        if (isAlcohol || !isLunch) {
            System.out.println(280);
        } else if (isLunch && !isAlcohol) {
            System.out.println(320);
        }
    }

}