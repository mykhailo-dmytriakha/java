package utils.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static utils.strings.StringUtil.isAnagrams;
import static utils.strings.StringUtil.isPalindrome;
import static utils.strings.StringUtil.sortLettersInString;

/**
 * Created by Михаил on 11.02.2016.
 */
public class StringUtilTest {

    @Test
    public void testIsPalindrome() throws Exception {
        assertTrue(isPalindrome(""));
        assertTrue(isPalindrome("waw"));
        assertTrue(isPalindrome("ww"));
        assertTrue(isPalindrome("w"));
        assertTrue(isPalindrome("qwertyuiopoiuytrewq"));
        assertTrue(isPalindrome("qwertyuiooiuytrewq"));
        assertFalse(isPalindrome("asd"));
        assertFalse(isPalindrome("as"));
    }

    @Test
    public void testIsAnagrams() throws Exception {
        assertTrue(isAnagrams("asd", "dsa"));
        assertTrue(isAnagrams("edcba", "abcde"));
        assertTrue(isAnagrams("edcBa", "abCde"));
        assertTrue(isAnagrams("edcdddba", "dadbdcde"));
        assertFalse(isAnagrams("asd", "asc"));
        assertFalse(isAnagrams("asdc", "asc"));
    }

    @Test
    public void testSortLettersInString() throws Exception {
        assertEquals(sortLettersInString("caB"), "Bac");
        assertEquals(sortLettersInString("bca"), "abc");
        assertEquals(sortLettersInString("edcba"), "abcde");
    }
}