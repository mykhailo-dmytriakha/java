package utils.array;

import java.util.ArrayList;

import static define.Predef.require;

public class ArrayUtil {
    /**
     * @param list  list with all elements
     * @param index index of element that will be not include to result list
     * @return other elements in list
     */
    public static <T> ArrayList<T> getOtherElements(ArrayList<T> list, int index) {
        require(list.size() >= 2, "size of List need to be 2 or more");
        require(index >= 0 && index < list.size(), "index need to be 0 or more and less then size of list");

        ArrayList<T> otherElem = new ArrayList<>(list.size() - 1);
        T elemValue = list.get(index);
        for (T elem : list) {
            if (!elemValue.equals(elem)) {
                otherElem.add(elem);
            }
        }
        return otherElem;
    }
}
