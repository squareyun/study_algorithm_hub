import java.io.*;
import java.util.*;

public class Main {

    private static final int[] YEAR = {
            1967, 1969, 1970, 1971, 1972,
            1973, 1973, 1974, 1975, 1976,
            1977, 1977, 1979, 1980, 1983,
            1984, 1987, 1993, 1995, 1997,
            1999, 2002, 2003, 2013, 2016
    };

    private static final String[] NAME = {
            "DavidBowie", "SpaceOddity", "TheManWhoSoldTheWorld", "HunkyDory",
            "TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars",
            "AladdinSane", "PinUps", "DiamondDogs", "YoungAmericans", "StationToStation",
            "Low", "Heroes", "Lodger", "ScaryMonstersAndSuperCreeps", "LetsDance",
            "Tonight", "NeverLetMeDown", "BlackTieWhiteNoise", "1.Outside", "Earthling",
            "Hours", "Heathen", "Reality", "TheNextDay", "BlackStar"
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());

        while (Q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            List<String> result = new ArrayList<>();

            for (int i = 0; i < YEAR.length; i++) {
                if (YEAR[i] >= S && YEAR[i] <= E) {
                    result.add(YEAR[i] + " " + NAME[i]);
                }
            }

            System.out.println(result.size());
            for (String line : result) {
                System.out.println(line);
            }
        }
    }
}