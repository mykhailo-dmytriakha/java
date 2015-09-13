import utils.math.MathUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> permutedList;
        permutedList = MathUtil.permuteList(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4)));

        System.out.println(permutedList);

    }
}
