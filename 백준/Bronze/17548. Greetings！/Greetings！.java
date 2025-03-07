import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append("h");
        sb.append("e".repeat((s.length() - 2) * 2));
        sb.append("y");
        System.out.println(sb);
    }

}