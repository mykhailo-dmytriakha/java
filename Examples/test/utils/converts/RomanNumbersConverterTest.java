package utils.converts;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author by Mykhailo on 8/3/2018.
 */
public class RomanNumbersConverterTest {
    @Test(expected = IllegalArgumentException.class)
    public void validate() throws Exception {

        RomanNumbersConverter.validate("");
    }

}