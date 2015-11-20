package _mains;

import utils.math.MathUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class MainPermutation {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> permutedList;
        permutedList = MathUtil.permuteList(new ArrayList<>(Arrays.asList(1, 2, 4)));


        Set<Set<Integer>> allSubSets = MathUtil.getAllSubsetsOfSet(new ArrayList<>(Arrays.asList(1, 2, 4)));

        System.out.println(permutedList);
        System.out.println();
        System.out.println(allSubSets);

    }
}
