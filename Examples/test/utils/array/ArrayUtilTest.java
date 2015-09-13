package utils.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ArrayUtilTest {

    @Test
    public void testGetOtherElements() throws Exception {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertEquals(new ArrayList<>(Arrays.asList(2, 3)), ArrayUtil.getOtherElements(list, 0));
        assertEquals(new ArrayList<>(Arrays.asList(1, 3)), ArrayUtil.getOtherElements(list, 1));
        assertEquals(new ArrayList<>(Arrays.asList(1, 2)), ArrayUtil.getOtherElements(list, 2));
    }
}