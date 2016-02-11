package utils.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static utils.strings.StringUtil.isPalindrome;

/**
 * Created by Михаил on 11.02.2016.
 */
public class StringsUtilTest {

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
}