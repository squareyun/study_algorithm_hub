import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        char first = s.charAt(0);
        int n = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == first)
                n++;
            else
                break;
        }
        System.out.println(n);
    }
}
