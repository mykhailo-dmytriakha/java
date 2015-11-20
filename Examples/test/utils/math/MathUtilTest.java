package utils.math;

import org.junit.Test;

import java.util.Arrays;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by mdmytiaha on 20-Nov-15.
 */
public class MathUtilTest {

    @Test
    public void testGetPrimesUp() {
        assertEquals(new TreeSet<>(Arrays.asList(1, 2, 3, 5, 7)), MathUtil.getPrimesUp(7L));
        assertEquals(new TreeSet<>(Arrays.asList(1, 2, 3, 5, 7)), MathUtil.getPrimesUp(8L));
        assertEquals(new TreeSet<>(Arrays.asList(1, 2, 3, 5, 7)), MathUtil.getPrimesUp(9L));
        assertEquals(new TreeSet<>(Arrays.asList(1, 2, 3, 5, 7)), MathUtil.getPrimesUp(10L));
        assertEquals(new TreeSet<>(Arrays.asList(1, 2, 3, 5, 7, 11)), MathUtil.getPrimesUp(11L));
    }

    @Test
    public void testIsPrimeNumber(){
        assertTrue(MathUtil.isPrimeNumber(11));
        assertTrue(MathUtil.isPrimeNumber(7));
        assertFalse(MathUtil.isPrimeNumber(21));
        assertTrue(MathUtil.isPrimeNumber(11));
        assertFalse(MathUtil.isPrimeNumber(92));
    }
}