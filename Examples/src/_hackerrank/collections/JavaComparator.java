package _hackerrank.collections;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * <p>task description https://www.hackerrank.com/challenges/java-comparator</p>
 */
public class JavaComparator {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        String s;
        StringTokenizer st;
        Player Player[] = new Player[N];
        Checker check = new Checker();
        for (int i = 0; i < N; i++) {
            s = br.readLine().trim();
            st = new StringTokenizer(s);
            Player[i] = new Player();
            Player[i].name = st.nextToken();
            Player[i].score = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Player, check.desc);
        for (int i = 0; i < Player.length; i++) {
            System.out.printf("%s %s\n", Player[i].name, Player[i].score);
        }
    }
}

class Player {
    String name;
    int score;
}

class Checker {

    public Comparator<? super Player> desc = new Comparator<Player>() {
        @Override
        public int compare(Player p1, Player p2) {
            int diff = p2.score - p1.score;
            if(diff != 0){
                return diff;
            } else {
                return p2.name.compareTo(p1.name);
            }
        }
    };
}

