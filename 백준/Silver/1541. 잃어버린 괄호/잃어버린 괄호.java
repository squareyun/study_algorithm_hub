import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] minus = br.readLine().split("\\-");

        int answer = 0;
        for (int i = 0; i < minus.length; i++) {
            String[] plus = minus[i].split("\\+");

            int calc = 0;
            for (String p : plus) {
                calc += Integer.parseInt(p);
            }

            if (i == 0) {
                answer += calc;
            } else {
                answer -= calc;
            }
        }

        System.out.println(answer);
    }

}