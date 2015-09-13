package utils.math;

import utils.array.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;

import static define.Predef.requier;

public class MathUtil {

    public static <T> ArrayList<ArrayList<T>> permuteList(ArrayList<T> list) {

        int listSize = list.size();
        requier(listSize >= 2);
        ArrayList<ArrayList<T>> permutedLists = new ArrayList<>(listSize);

        if (listSize == 2) {
            permutedLists.add(list);
            permutedLists.add(new ArrayList<T>(Arrays.asList(list.get(1), list.get(0))));
            return permutedLists;
        } else {
            for (int i = 0; i < listSize; i++) {
                T elem = list.get(i);
                ArrayList<T> otherElements = ArrayUtil.getOtherElements(list, i);
                for (ArrayList<T> e : permuteList(otherElements)) {
                    e.add(0, elem);
                    permutedLists.add(e);
                }
            }
            return permutedLists;
        }
    }
}
